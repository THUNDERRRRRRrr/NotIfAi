package com.notifai.ai

import android.util.Log
import com.notifai.data.model.AIResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AIProviderManager @Inject constructor(
    private val groqProvider: GroqProvider,
    private val openRouterProvider: OpenRouterProvider,
    private val openAiProvider: OpenAIProvider,
    private val geminiProvider: GeminiProvider,
    private val apiKeyManager: ApiKeyManager,
) {
    private val _activeProvider = MutableStateFlow("none")
    val activeProvider: StateFlow<String> = _activeProvider.asStateFlow()

    private val _lastConfidence = MutableStateFlow(0f)
    val lastConfidence: StateFlow<Float> = _lastConfidence.asStateFlow()

    private val _lastPingMs = MutableStateFlow(0L)
    val lastPingMs: StateFlow<Long> = _lastPingMs.asStateFlow()

    private val _cascadeCount = MutableStateFlow(0)
    val cascadeCount: StateFlow<Int> = _cascadeCount.asStateFlow()

    private val _lastError = MutableStateFlow("")
    val lastError: StateFlow<String> = _lastError.asStateFlow()

    private val _providerErrors = MutableStateFlow<Map<String, String>>(emptyMap())
    val providerErrors: StateFlow<Map<String, String>> = _providerErrors.asStateFlow()

    suspend fun classifyNotification(
        appName: String,
        title: String,
        body: String,
    ): AIResponse {
        val prefs = apiKeyManager.getAIModelPreferences()
        var bestResponse: AIResponse? = null
        val errors = mutableMapOf<String, String>()

        Log.d(TAG, "Starting classification cascade: ${prefs.cascadeOrder}")

        for (providerName in prefs.cascadeOrder) {
            try {
                Log.d(TAG, "Trying provider: $providerName")
                val startTime = System.currentTimeMillis()
                val response = callProvider(providerName, appName, title, body)
                val pingTime = System.currentTimeMillis() - startTime

                _lastPingMs.value = pingTime
                _activeProvider.value = providerName
                _lastConfidence.value = response.confidence

                Log.d(TAG, "$providerName succeeded in ${pingTime}ms — " +
                    "category=${response.category} confidence=${response.confidence}")

                _lastError.value = ""
                _providerErrors.value = errors.toMap()

                if (!prefs.enableCascading) return response

                if (response.confidence >= prefs.confidenceThreshold) {
                    return response
                }

                Log.d(
                    TAG,
                    "$providerName confidence ${response.confidence} " +
                        "below ${prefs.confidenceThreshold}, cascading...",
                )
                _cascadeCount.value++

                if (bestResponse == null || response.confidence > bestResponse.confidence) {
                    bestResponse = response
                }
            } catch (e: Exception) {
                if (e is kotlinx.coroutines.CancellationException) throw e
                val errorMsg = e.message ?: "Unknown error"
                errors[providerName] = errorMsg
                Log.e(TAG, "$providerName failed: $errorMsg", e)
                continue
            }
        }

        _providerErrors.value = errors.toMap()
        if (bestResponse == null && errors.isNotEmpty()) {
            val summary = errors.entries.joinToString(" | ") { "${it.key}: ${it.value}" }
            _lastError.value = summary
            Log.e(TAG, "All providers failed: $summary")
        }

        return bestResponse ?: AIResponse(
            category = "UNKNOWN",
            confidence = 0f,
            reason = if (errors.isNotEmpty()) {
                "All providers failed → " + errors.entries.joinToString("; ") {
                    "${it.key}: ${it.value}"
                }
            } else {
                "All providers failed"
            },
            shouldBlock = false,
        )
    }

    private suspend fun callProvider(
        providerName: String,
        appName: String,
        title: String,
        body: String,
    ): AIResponse = when (providerName) {
        "groq"       -> groqProvider.classify(appName, title, body)
        "openrouter" -> openRouterProvider.classify(appName, title, body)
        "openai"     -> openAiProvider.classify(appName, title, body)
        "gemini"     -> geminiProvider.classify(appName, title, body)
        else         -> throw IllegalArgumentException("Unknown provider: $providerName")
    }

    companion object {
        private const val TAG = "AIProviderManager"
    }
}

