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

    suspend fun classifyNotification(
        appName: String,
        title: String,
        body: String,
    ): AIResponse {
        val prefs = apiKeyManager.getAIModelPreferences()
        var bestResponse: AIResponse? = null

        for (providerName in prefs.cascadeOrder) {
            try {
                val startTime = System.currentTimeMillis()
                val response = callProvider(providerName, appName, title, body)
                val pingTime = System.currentTimeMillis() - startTime
                
                _lastPingMs.value = pingTime
                _activeProvider.value = providerName
                _lastConfidence.value = response.confidence

                // If cascading is disabled, return the first successful result
                if (!prefs.enableCascading) return response

                // If confidence meets the threshold, we're done
                if (response.confidence >= prefs.confidenceThreshold) {
                    return response
                }

                Log.d(
                    TAG,
                    "$providerName confidence ${response.confidence} " +
                        "below ${prefs.confidenceThreshold}, cascading...",
                )
                _cascadeCount.value++

                // Track the best response seen so far
                if (bestResponse == null || response.confidence > bestResponse.confidence) {
                    bestResponse = response
                }
            } catch (e: Exception) {
                if (e is kotlinx.coroutines.CancellationException) throw e
                Log.w(TAG, "$providerName failed: ${e.message}")
                continue
            }
        }

        // Return the best response we got, or a fallback UNKNOWN
        return bestResponse ?: AIResponse(
            category = "UNKNOWN",
            confidence = 0f,
            reason = "All providers failed",
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
        "gemini"     -> geminiProvider.classify(appName, title, body)
        else         -> throw IllegalArgumentException("Unknown provider: $providerName")
    }

    companion object {
        private const val TAG = "AIProviderManager"
    }
}
