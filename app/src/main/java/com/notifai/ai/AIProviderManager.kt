package com.notifai.ai

import com.notifai.data.model.AIResponse
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Orchestrates the multi-tier AI fallback chain:
 *   Groq → OpenRouter → Gemini
 *
 * TODO: Full implementation by teammate.
 * This stub satisfies the compiler so the rest of the project can be built
 * and tested independently.
 */
@Singleton
class AIProviderManager @Inject constructor() {

    /**
     * The identifier of the provider that handled the most recent
     * classification call ("groq", "openrouter", or "gemini").
     * Set by the active provider implementation.
     */
    var lastUsedProvider: String = "unknown"
        internal set

    /**
     * Classifies a notification and returns an [AIResponse].
     *
     * @throws NotImplementedError until the real implementation is wired in.
     */
    suspend fun classifyNotification(
        packageName: String,
        appName: String,
        title: String,
        body: String,
    ): AIResponse {
        // Placeholder — replace with Groq → OpenRouter → Gemini fallback chain
        throw NotImplementedError("AIProviderManager.classifyNotification is not yet implemented")
    }
}
