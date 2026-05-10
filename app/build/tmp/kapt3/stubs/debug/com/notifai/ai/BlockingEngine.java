package com.notifai.ai;

import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/notifai/ai/BlockingEngine;", "", "apiKeyManager", "Lcom/notifai/ai/ApiKeyManager;", "(Lcom/notifai/ai/ApiKeyManager;)V", "shouldBlock", "", "category", "", "confidence", "", "app_debug"})
public final class BlockingEngine {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.ApiKeyManager apiKeyManager = null;
    
    @javax.inject.Inject()
    public BlockingEngine(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.ApiKeyManager apiKeyManager) {
        super();
    }
    
    /**
     * Decides whether a notification should be blocked based on the user's
     * per-category preferences and the AI's confidence score.
     */
    public final boolean shouldBlock(@org.jetbrains.annotations.NotNull()
    java.lang.String category, float confidence) {
        return false;
    }
}