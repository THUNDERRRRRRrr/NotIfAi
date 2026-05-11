package com.notifai.ai

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.google.gson.Gson
import com.notifai.data.model.AIModelPreferences
import com.notifai.data.model.BlockingPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiKeyManager @Inject constructor(
    @ApplicationContext context: Context
) {

    private val gson = Gson()

    private val sharedPreferences by lazy {
        try {
            val masterKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()

            EncryptedSharedPreferences.create(
                context,
                "notifai_api_keys",
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        } catch (e: Exception) {
            // Fallback to regular SharedPreferences if Keystore is corrupted
            context.getSharedPreferences("notifai_api_keys_fallback", Context.MODE_PRIVATE)
        }
    }

    // ── API Keys ──────────────────────────────────────────────────────────────

    fun saveGroqKey(key: String) {
        sharedPreferences.edit().putString(KEY_GROQ, key).apply()
    }

    fun saveOpenRouterKey(key: String) {
        sharedPreferences.edit().putString(KEY_OPENROUTER, key).apply()
    }

    fun saveGeminiKey(key: String) {
        sharedPreferences.edit().putString(KEY_GEMINI, key).apply()
    }

    fun getGroqKey(): String? {
        return sharedPreferences.getString(KEY_GROQ, null)
    }

    fun getOpenRouterKey(): String? {
        return sharedPreferences.getString(KEY_OPENROUTER, null)
    }

    fun getGeminiKey(): String? {
        return sharedPreferences.getString(KEY_GEMINI, null)
    }

    // ── Active Provider ───────────────────────────────────────────────────────

    fun getActiveProvider(): String =
        sharedPreferences.getString(KEY_ACTIVE_PROVIDER, DEFAULT_PROVIDER) ?: DEFAULT_PROVIDER

    fun setActiveProvider(provider: String) {
        sharedPreferences.edit().putString(KEY_ACTIVE_PROVIDER, provider).apply()
    }

    // ── Blocking Preferences ──────────────────────────────────────────────────

    fun saveBlockingPreferences(prefs: BlockingPreferences) {
        sharedPreferences.edit().putString(KEY_BLOCKING_PREFS, gson.toJson(prefs)).apply()
    }

    fun getBlockingPreferences(): BlockingPreferences {
        val json = sharedPreferences.getString(KEY_BLOCKING_PREFS, null)
            ?: return BlockingPreferences()
        return try {
            gson.fromJson(json, BlockingPreferences::class.java)
        } catch (e: Exception) {
            BlockingPreferences()
        }
    }

    // ── AI Model Preferences (cascading + model selection) ────────────────────

    fun saveAIModelPreferences(prefs: AIModelPreferences) {
        sharedPreferences.edit().putString(KEY_AI_MODEL_PREFS, gson.toJson(prefs)).apply()
    }

    fun getAIModelPreferences(): AIModelPreferences {
        val json = sharedPreferences.getString(KEY_AI_MODEL_PREFS, null)
            ?: return AIModelPreferences()
        return try {
            gson.fromJson(json, AIModelPreferences::class.java)
        } catch (e: Exception) {
            AIModelPreferences()
        }
    }

    companion object {
        private const val KEY_GROQ = "pref_groq"
        private const val KEY_OPENROUTER = "pref_openrouter"
        private const val KEY_GEMINI = "pref_gemini"
        private const val KEY_ACTIVE_PROVIDER = "pref_active_provider"
        private const val KEY_BLOCKING_PREFS = "pref_blocking_prefs"
        private const val KEY_AI_MODEL_PREFS = "pref_ai_model_prefs"
        private const val DEFAULT_PROVIDER = "gemini"
    }
}
