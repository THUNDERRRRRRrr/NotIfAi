package com.notifai.security;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Manages encrypted storage and retrieval of AI provider API keys.
 *
 * TODO: Full implementation by teammate — this is a compilation stub.
 *
 * The real implementation will use [androidx.security.crypto.EncryptedSharedPreferences]
 * to persist keys securely, and expose Flow-based streams for reactive UI updates.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/notifai/security/ApiKeyManager;", "", "()V", "getActiveProvider", "", "getGeminiKey", "getGroqKey", "getOpenRouterKey", "saveGeminiKey", "", "key", "saveGroqKey", "saveOpenRouterKey", "setActiveProvider", "provider", "app_debug"})
public final class ApiKeyManager {
    
    @javax.inject.Inject()
    public ApiKeyManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGroqKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOpenRouterKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGeminiKey() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActiveProvider() {
        return null;
    }
    
    public final void setActiveProvider(@org.jetbrains.annotations.NotNull()
    java.lang.String provider) {
    }
}