package com.notifai.ai;

import android.util.Log;
import com.notifai.data.model.AIResponse;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ.\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0082@\u00a2\u0006\u0002\u0010 J&\u0010!\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\"R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/notifai/ai/AIProviderManager;", "", "groqProvider", "Lcom/notifai/ai/GroqProvider;", "openRouterProvider", "Lcom/notifai/ai/OpenRouterProvider;", "geminiProvider", "Lcom/notifai/ai/GeminiProvider;", "apiKeyManager", "Lcom/notifai/ai/ApiKeyManager;", "(Lcom/notifai/ai/GroqProvider;Lcom/notifai/ai/OpenRouterProvider;Lcom/notifai/ai/GeminiProvider;Lcom/notifai/ai/ApiKeyManager;)V", "_activeProvider", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_cascadeCount", "", "_lastConfidence", "", "activeProvider", "Lkotlinx/coroutines/flow/StateFlow;", "getActiveProvider", "()Lkotlinx/coroutines/flow/StateFlow;", "cascadeCount", "getCascadeCount", "lastConfidence", "getLastConfidence", "callProvider", "Lcom/notifai/data/model/AIResponse;", "providerName", "appName", "title", "body", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "classifyNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class AIProviderManager {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.GroqProvider groqProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.OpenRouterProvider openRouterProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.GeminiProvider geminiProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.ApiKeyManager apiKeyManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _activeProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> activeProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> _lastConfidence = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Float> lastConfidence = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _cascadeCount = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> cascadeCount = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AIProviderManager";
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.ai.AIProviderManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public AIProviderManager(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.GroqProvider groqProvider, @org.jetbrains.annotations.NotNull()
    com.notifai.ai.OpenRouterProvider openRouterProvider, @org.jetbrains.annotations.NotNull()
    com.notifai.ai.GeminiProvider geminiProvider, @org.jetbrains.annotations.NotNull()
    com.notifai.ai.ApiKeyManager apiKeyManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getActiveProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Float> getLastConfidence() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getCascadeCount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object classifyNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String appName, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.notifai.data.model.AIResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object callProvider(java.lang.String providerName, java.lang.String appName, java.lang.String title, java.lang.String body, kotlin.coroutines.Continuation<? super com.notifai.data.model.AIResponse> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/notifai/ai/AIProviderManager$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}