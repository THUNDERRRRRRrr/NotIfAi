package com.notifai.ai

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiKeyManager @Inject constructor(
    @ApplicationContext context: Context
) {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "notifai_api_keys",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

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

    companion object {
        private const val KEY_GROQ = "pref_groq"
        private const val KEY_OPENROUTER = "pref_openrouter"
        private const val KEY_GEMINI = "pref_gemini"
    }
}
