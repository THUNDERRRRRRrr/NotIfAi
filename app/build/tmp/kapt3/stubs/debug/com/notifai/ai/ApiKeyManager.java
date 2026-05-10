package com.notifai.ai;

import android.content.Context;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/notifai/ai/ApiKeyManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "masterKey", "Landroidx/security/crypto/MasterKey;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getGeminiKey", "", "getGroqKey", "getOpenRouterKey", "saveGeminiKey", "", "key", "saveGroqKey", "saveOpenRouterKey", "Companion", "app_debug"})
public final class ApiKeyManager {
    @org.jetbrains.annotations.NotNull()
    private final androidx.security.crypto.MasterKey masterKey = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_GROQ = "pref_groq";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_OPENROUTER = "pref_openrouter";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_GEMINI = "pref_gemini";
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.ai.ApiKeyManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public ApiKeyManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/notifai/ai/ApiKeyManager$Companion;", "", "()V", "KEY_GEMINI", "", "KEY_GROQ", "KEY_OPENROUTER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}