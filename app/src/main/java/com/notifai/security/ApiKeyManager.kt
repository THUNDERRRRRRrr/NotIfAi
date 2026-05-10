package com.notifai.security

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages encrypted storage and retrieval of AI provider API keys.
 *
 * TODO: Full implementation by teammate — this is a compilation stub.
 *
 * The real implementation will use [androidx.security.crypto.EncryptedSharedPreferences]
 * to persist keys securely, and expose Flow-based streams for reactive UI updates.
 */
@Singleton
class ApiKeyManager @Inject constructor() {

    fun getGroqKey(): String = ""
    fun getOpenRouterKey(): String = ""
    fun getGeminiKey(): String = ""

    fun saveGroqKey(key: String): Unit =
        throw NotImplementedError("ApiKeyManager.saveGroqKey not yet implemented")

    fun saveOpenRouterKey(key: String): Unit =
        throw NotImplementedError("ApiKeyManager.saveOpenRouterKey not yet implemented")

    fun saveGeminiKey(key: String): Unit =
        throw NotImplementedError("ApiKeyManager.saveGeminiKey not yet implemented")

    fun getActiveProvider(): String = "groq"

    fun setActiveProvider(provider: String): Unit =
        throw NotImplementedError("ApiKeyManager.setActiveProvider not yet implemented")
}
