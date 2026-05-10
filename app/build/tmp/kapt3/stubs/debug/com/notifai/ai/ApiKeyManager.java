package com.notifai.ai;

import android.content.Context;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.google.gson.Gson;
import com.notifai.data.model.AIModelPreferences;
import com.notifai.data.model.BlockingPreferences;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\""}, d2 = {"Lcom/notifai/ai/ApiKeyManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "getAIModelPreferences", "Lcom/notifai/data/model/AIModelPreferences;", "getActiveProvider", "", "getBlockingPreferences", "Lcom/notifai/data/model/BlockingPreferences;", "getGeminiKey", "getGroqKey", "getOpenRouterKey", "saveAIModelPreferences", "", "prefs", "saveBlockingPreferences", "saveGeminiKey", "key", "saveGroqKey", "saveOpenRouterKey", "setActiveProvider", "provider", "Companion", "app_debug"})
public final class ApiKeyManager {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy sharedPreferences$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_GROQ = "pref_groq";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_OPENROUTER = "pref_openrouter";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_GEMINI = "pref_gemini";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ACTIVE_PROVIDER = "pref_active_provider";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_BLOCKING_PREFS = "pref_blocking_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_AI_MODEL_PREFS = "pref_ai_model_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_PROVIDER = "groq";
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.ai.ApiKeyManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public ApiKeyManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final android.content.SharedPreferences getSharedPreferences() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGroqKey() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOpenRouterKey() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGeminiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActiveProvider() {
        return null;
    }
    
    public final void setActiveProvider(@org.jetbrains.annotations.NotNull()
    java.lang.String provider) {
    }
    
    public final void saveBlockingPreferences(@org.jetbrains.annotations.NotNull()
    com.notifai.data.model.BlockingPreferences prefs) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.data.model.BlockingPreferences getBlockingPreferences() {
        return null;
    }
    
    public final void saveAIModelPreferences(@org.jetbrains.annotations.NotNull()
    com.notifai.data.model.AIModelPreferences prefs) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.data.model.AIModelPreferences getAIModelPreferences() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/notifai/ai/ApiKeyManager$Companion;", "", "()V", "DEFAULT_PROVIDER", "", "KEY_ACTIVE_PROVIDER", "KEY_AI_MODEL_PREFS", "KEY_BLOCKING_PREFS", "KEY_GEMINI", "KEY_GROQ", "KEY_OPENROUTER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}