package com.notifai.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notifai.security.ApiKeyManager
import com.notifai.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val apiKeyManager: ApiKeyManager,
) : ViewModel() {

    // ── API key state (masked for display) ────────────────────────────────────

    private val _groqKey = MutableStateFlow(apiKeyManager.getGroqKey().masked())
    val groqKey: StateFlow<String> = _groqKey.asStateFlow()

    private val _openRouterKey = MutableStateFlow(apiKeyManager.getOpenRouterKey().masked())
    val openRouterKey: StateFlow<String> = _openRouterKey.asStateFlow()

    private val _geminiKey = MutableStateFlow(apiKeyManager.getGeminiKey().masked())
    val geminiKey: StateFlow<String> = _geminiKey.asStateFlow()

    // ── Active provider ───────────────────────────────────────────────────────

    private val _activeProvider = MutableStateFlow(apiKeyManager.getActiveProvider())
    val activeProvider: StateFlow<String> = _activeProvider.asStateFlow()

    // ── Sensitivity ───────────────────────────────────────────────────────────

    private val _sensitivityLevel = MutableStateFlow(SensitivityLevel.DEFAULT)
    val sensitivityLevel: StateFlow<SensitivityLevel> = _sensitivityLevel.asStateFlow()

    // ── Save state (for showing spinners / error toasts) ──────────────────────

    private val _saveState = MutableStateFlow<UiState<Unit>>(UiState.Success(Unit))
    val saveState: StateFlow<UiState<Unit>> = _saveState.asStateFlow()

    // ── Actions ───────────────────────────────────────────────────────────────

    fun saveGroqKey(key: String) = saveKey(key) {
        apiKeyManager.saveGroqKey(key)
        _groqKey.value = key.masked()
    }

    fun saveOpenRouterKey(key: String) = saveKey(key) {
        apiKeyManager.saveOpenRouterKey(key)
        _openRouterKey.value = key.masked()
    }

    fun saveGeminiKey(key: String) = saveKey(key) {
        apiKeyManager.saveGeminiKey(key)
        _geminiKey.value = key.masked()
    }

    fun setSensitivity(level: SensitivityLevel) {
        _sensitivityLevel.value = level
        // TODO: persist via ApiKeyManager / SharedPreferences when the real
        //       ApiKeyManager is implemented.
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private fun saveKey(key: String, block: () -> Unit) {
        if (key.isBlank()) return
        viewModelScope.launch {
            _saveState.value = UiState.Loading
            runCatching { block() }
                .onSuccess { _saveState.value = UiState.Success(Unit) }
                .onFailure { _saveState.value = UiState.Error("Failed to save key", it) }
        }
    }

    companion object {
        /**
         * Masks an API key for safe display.
         * "sk-abc123foobar9999" → "sk-...9999"
         * Keys shorter than 9 chars are fully masked.
         */
        fun String.masked(): String = when {
            isBlank() -> ""
            length <= 8 -> "•".repeat(length)
            else -> take(3) + "..." + takeLast(4)
        }
    }
}
