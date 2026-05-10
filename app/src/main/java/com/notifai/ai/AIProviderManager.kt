package com.notifai.ai

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
    private val geminiProvider: GeminiProvider
) {
    private val _activeProvider = MutableStateFlow("none")
    val activeProvider: StateFlow<String> = _activeProvider.asStateFlow()

    suspend fun classifyNotification(appName: String, title: String, body: String): AIResponse {
        try {
            _activeProvider.value = "groq"
            return groqProvider.classify(appName, title, body)
        } catch (e: Exception) {
            // Fallback to OpenRouter
        }
        
        try {
            _activeProvider.value = "openrouter"
            return openRouterProvider.classify(appName, title, body)
        } catch (e: Exception) {
            // Fallback to Gemini
        }
        
        try {
            _activeProvider.value = "gemini"
            return geminiProvider.classify(appName, title, body)
        } catch (e: Exception) {
            // All failed
            _activeProvider.value = "none"
            return AIResponse(
                category = "UNKNOWN",
                confidence = 0f,
                reason = "All AI providers failed: ${e.message}",
                shouldBlock = false
            )
        }
    }
}
