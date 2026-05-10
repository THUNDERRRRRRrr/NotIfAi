package com.notifai.ui.settings;

import androidx.lifecycle.ViewModel;
import com.notifai.security.ApiKeyManager;
import com.notifai.ui.common.UiState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007J\u001e\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0#H\u0002J\u000e\u0010$\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013\u00a8\u0006("}, d2 = {"Lcom/notifai/ui/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "apiKeyManager", "Lcom/notifai/security/ApiKeyManager;", "(Lcom/notifai/security/ApiKeyManager;)V", "_activeProvider", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_geminiKey", "_groqKey", "_openRouterKey", "_saveState", "Lcom/notifai/ui/common/UiState;", "", "_sensitivityLevel", "Lcom/notifai/ui/settings/SensitivityLevel;", "activeProvider", "Lkotlinx/coroutines/flow/StateFlow;", "getActiveProvider", "()Lkotlinx/coroutines/flow/StateFlow;", "geminiKey", "getGeminiKey", "groqKey", "getGroqKey", "openRouterKey", "getOpenRouterKey", "saveState", "getSaveState", "sensitivityLevel", "getSensitivityLevel", "saveGeminiKey", "key", "saveGroqKey", "saveKey", "block", "Lkotlin/Function0;", "saveOpenRouterKey", "setSensitivity", "level", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.security.ApiKeyManager apiKeyManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _groqKey = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> groqKey = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _openRouterKey = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> openRouterKey = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _geminiKey = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> geminiKey = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _activeProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> activeProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notifai.ui.settings.SensitivityLevel> _sensitivityLevel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.settings.SensitivityLevel> sensitivityLevel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notifai.ui.common.UiState<kotlin.Unit>> _saveState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<kotlin.Unit>> saveState = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.ui.settings.SettingsViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.notifai.security.ApiKeyManager apiKeyManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getGroqKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getOpenRouterKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getGeminiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getActiveProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.settings.SensitivityLevel> getSensitivityLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<kotlin.Unit>> getSaveState() {
        return null;
    }
    
    public final void saveGroqKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public final void saveOpenRouterKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public final void saveGeminiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public final void setSensitivity(@org.jetbrains.annotations.NotNull()
    com.notifai.ui.settings.SensitivityLevel level) {
    }
    
    private final void saveKey(java.lang.String key, kotlin.jvm.functions.Function0<kotlin.Unit> block) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/notifai/ui/settings/SettingsViewModel$Companion;", "", "()V", "masked", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Masks an API key for safe display.
         * "sk-abc123foobar9999" → "sk-...9999"
         * Keys shorter than 9 chars are fully masked.
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String masked(@org.jetbrains.annotations.NotNull()
        java.lang.String $this$masked) {
            return null;
        }
    }
}