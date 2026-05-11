package com.notifai.ui.settings;

import androidx.lifecycle.ViewModel;
import com.notifai.ai.ApiKeyManager;
import com.notifai.data.model.AIModelPreferences;
import com.notifai.data.model.BlockingPreferences;
import com.notifai.ui.common.UiState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bJ\u000e\u0010+\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bJ2\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000b2\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\u00062\f\u0010.\u001a\b\u0012\u0004\u0012\u00020)0/H\u0002J\u000e\u00100\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bJ\u000e\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u0013J\u000e\u00103\u001a\u00020)2\u0006\u00104\u001a\u000205J\u001c\u00106\u001a\u00020)2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000708H\u0002J\u0016\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010.\u001a\u000205J\u000e\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020)2\u0006\u0010<\u001a\u00020=R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0017\u00a8\u0006@"}, d2 = {"Lcom/notifai/ui/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "apiKeyManager", "Lcom/notifai/ai/ApiKeyManager;", "(Lcom/notifai/ai/ApiKeyManager;)V", "_aiModelPreferences", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/notifai/data/model/AIModelPreferences;", "_blockingPreferences", "Lcom/notifai/data/model/BlockingPreferences;", "_geminiKey", "", "_geminiSaveState", "Lcom/notifai/ui/common/UiState;", "_groqKey", "_groqSaveState", "_openRouterKey", "_openRouterSaveState", "_sensitivityLevel", "Lcom/notifai/ui/settings/SensitivityLevel;", "aiModelPreferences", "Lkotlinx/coroutines/flow/StateFlow;", "getAiModelPreferences", "()Lkotlinx/coroutines/flow/StateFlow;", "blockingPreferences", "getBlockingPreferences", "geminiKey", "getGeminiKey", "geminiSaveState", "getGeminiSaveState", "groqKey", "getGroqKey", "groqSaveState", "getGroqSaveState", "openRouterKey", "getOpenRouterKey", "openRouterSaveState", "getOpenRouterSaveState", "sensitivityLevel", "getSensitivityLevel", "saveGeminiKey", "", "key", "saveGroqKey", "saveKey", "stateFlow", "block", "Lkotlin/Function0;", "saveOpenRouterKey", "setSensitivity", "level", "toggleCascading", "enabled", "", "updateAIModelPrefs", "transform", "Lkotlin/Function1;", "updateBlockingPreference", "category", "updateCascadeThreshold", "threshold", "", "updateConfidenceThreshold", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.ApiKeyManager apiKeyManager = null;
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
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notifai.ui.settings.SensitivityLevel> _sensitivityLevel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.settings.SensitivityLevel> sensitivityLevel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notifai.ui.common.UiState<java.lang.String>> _groqSaveState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.lang.String>> groqSaveState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notifai.ui.common.UiState<java.lang.String>> _openRouterSaveState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.lang.String>> openRouterSaveState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notifai.ui.common.UiState<java.lang.String>> _geminiSaveState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.lang.String>> geminiSaveState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notifai.data.model.BlockingPreferences> _blockingPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.data.model.BlockingPreferences> blockingPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notifai.data.model.AIModelPreferences> _aiModelPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.data.model.AIModelPreferences> aiModelPreferences = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.ui.settings.SettingsViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.ApiKeyManager apiKeyManager) {
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
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.settings.SensitivityLevel> getSensitivityLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.lang.String>> getGroqSaveState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.lang.String>> getOpenRouterSaveState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.lang.String>> getGeminiSaveState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.data.model.BlockingPreferences> getBlockingPreferences() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.data.model.AIModelPreferences> getAiModelPreferences() {
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
    
    public final void updateBlockingPreference(@org.jetbrains.annotations.NotNull()
    java.lang.String category, boolean block) {
    }
    
    public final void updateConfidenceThreshold(float threshold) {
    }
    
    public final void toggleCascading(boolean enabled) {
    }
    
    public final void updateCascadeThreshold(float threshold) {
    }
    
    private final void updateAIModelPrefs(kotlin.jvm.functions.Function1<? super com.notifai.data.model.AIModelPreferences, com.notifai.data.model.AIModelPreferences> transform) {
    }
    
    private final void saveKey(java.lang.String key, kotlinx.coroutines.flow.MutableStateFlow<com.notifai.ui.common.UiState<java.lang.String>> stateFlow, kotlin.jvm.functions.Function0<kotlin.Unit> block) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/notifai/ui/settings/SettingsViewModel$Companion;", "", "()V", "masked", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String masked(@org.jetbrains.annotations.NotNull()
        java.lang.String $this$masked) {
            return null;
        }
    }
}