package com.notifai.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notifai.ai.ApiKeyManager
import com.notifai.data.model.AIModelPreferences
import com.notifai.data.model.BlockingPreferences
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

    // ── API key display (masked) ───────────────────────────────────────────────

    private val _groqKey = MutableStateFlow(apiKeyManager.getGroqKey().orEmpty().masked())
    val groqKey: StateFlow<String> = _groqKey.asStateFlow()

    private val _openRouterKey = MutableStateFlow(apiKeyManager.getOpenRouterKey().orEmpty().masked())
    val openRouterKey: StateFlow<String> = _openRouterKey.asStateFlow()

    private val _geminiKey = MutableStateFlow(apiKeyManager.getGeminiKey().orEmpty().masked())
    val geminiKey: StateFlow<String> = _geminiKey.asStateFlow()

    // ── Sensitivity ───────────────────────────────────────────────────────────

    private val _sensitivityLevel = MutableStateFlow(SensitivityLevel.DEFAULT)
    val sensitivityLevel: StateFlow<SensitivityLevel> = _sensitivityLevel.asStateFlow()

    // ── Per-key save states ───────────────────────────────────────────────────

    private val _groqSaveState = MutableStateFlow<UiState<String>>(UiState.Success("idle"))
    val groqSaveState: StateFlow<UiState<String>> = _groqSaveState.asStateFlow()

    private val _openRouterSaveState = MutableStateFlow<UiState<String>>(UiState.Success("idle"))
    val openRouterSaveState: StateFlow<UiState<String>> = _openRouterSaveState.asStateFlow()

    private val _geminiSaveState = MutableStateFlow<UiState<String>>(UiState.Success("idle"))
    val geminiSaveState: StateFlow<UiState<String>> = _geminiSaveState.asStateFlow()

    // ── Blocking Preferences ──────────────────────────────────────────────────

    private val _blockingPreferences = MutableStateFlow(apiKeyManager.getBlockingPreferences())
    val blockingPreferences: StateFlow<BlockingPreferences> = _blockingPreferences.asStateFlow()

    // ── AI Model Preferences (cascading + model selection) ────────────────────

    private val _aiModelPreferences = MutableStateFlow(apiKeyManager.getAIModelPreferences())
    val aiModelPreferences: StateFlow<AIModelPreferences> = _aiModelPreferences.asStateFlow()

    // ── API Key Actions ───────────────────────────────────────────────────────

    fun saveGroqKey(key: String) = saveKey(key, _groqSaveState) {
        apiKeyManager.saveGroqKey(key)
        _groqKey.value = key.masked()
    }

    fun saveOpenRouterKey(key: String) = saveKey(key, _openRouterSaveState) {
        apiKeyManager.saveOpenRouterKey(key)
        _openRouterKey.value = key.masked()
    }

    fun saveGeminiKey(key: String) = saveKey(key, _geminiSaveState) {
        apiKeyManager.saveGeminiKey(key)
        _geminiKey.value = key.masked()
    }

    fun setSensitivity(level: SensitivityLevel) {
        _sensitivityLevel.value = level
    }

    // ── Blocking Preferences Actions ──────────────────────────────────────────

    fun updateBlockingPreference(category: String, block: Boolean) {
        val current = _blockingPreferences.value
        val updated = when (category.uppercase()) {
            "SPAM"        -> current.copy(blockSpam = block)
            "PHISHING"    -> current.copy(blockPhishing = block)
            "PROMOTIONAL" -> current.copy(blockPromotional = block)
            "UNKNOWN"     -> current.copy(blockUnknown = block)
            "DELIVERY"    -> current.copy(blockDelivery = block)
            "OTP"         -> current.copy(blockOtp = block)
            else          -> current
        }
        _blockingPreferences.value = updated
        apiKeyManager.saveBlockingPreferences(updated)
    }

    fun updateConfidenceThreshold(threshold: Float) {
        val updated = _blockingPreferences.value.copy(minConfidenceThreshold = threshold)
        _blockingPreferences.value = updated
        apiKeyManager.saveBlockingPreferences(updated)
    }

    // ── AI Model Preferences Actions ──────────────────────────────────────────

    fun toggleCascading(enabled: Boolean) {
        updateAIModelPrefs { it.copy(enableCascading = enabled) }
    }

    fun updateCascadeThreshold(threshold: Float) {
        updateAIModelPrefs { it.copy(confidenceThreshold = threshold) }
    }

    fun setGroqModel(model: String) {
        updateAIModelPrefs { it.copy(groqModel = model) }
    }

    fun setOpenRouterModel(model: String) {
        updateAIModelPrefs { it.copy(openRouterModel = model) }
    }

    private fun updateAIModelPrefs(transform: (AIModelPreferences) -> AIModelPreferences) {
        val updated = transform(_aiModelPreferences.value)
        _aiModelPreferences.value = updated
        apiKeyManager.saveAIModelPreferences(updated)
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private fun saveKey(
        key: String,
        stateFlow: MutableStateFlow<UiState<String>>,
        block: () -> Unit,
    ) {
        if (key.isBlank()) return
        viewModelScope.launch {
            stateFlow.value = UiState.Loading
            runCatching { block() }
                .onSuccess { stateFlow.value = UiState.Success("saved") }
                .onFailure { stateFlow.value = UiState.Error("Failed to save key: ${it.message}") }
        }
    }

    companion object {
        fun String.masked(): String = when {
            isBlank() -> ""
            length <= 8 -> "•".repeat(length)
            else -> take(3) + "..." + takeLast(4)
        }
    }
}
