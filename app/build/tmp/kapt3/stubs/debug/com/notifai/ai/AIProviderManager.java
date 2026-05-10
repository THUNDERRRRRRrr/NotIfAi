package com.notifai.ai;

import com.notifai.data.model.AIResponse;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0015R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/notifai/ai/AIProviderManager;", "", "groqProvider", "Lcom/notifai/ai/GroqProvider;", "openRouterProvider", "Lcom/notifai/ai/OpenRouterProvider;", "geminiProvider", "Lcom/notifai/ai/GeminiProvider;", "(Lcom/notifai/ai/GroqProvider;Lcom/notifai/ai/OpenRouterProvider;Lcom/notifai/ai/GeminiProvider;)V", "_activeProvider", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "activeProvider", "Lkotlinx/coroutines/flow/StateFlow;", "getActiveProvider", "()Lkotlinx/coroutines/flow/StateFlow;", "classifyNotification", "Lcom/notifai/data/model/AIResponse;", "appName", "title", "body", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AIProviderManager {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.GroqProvider groqProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.OpenRouterProvider openRouterProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.GeminiProvider geminiProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _activeProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> activeProvider = null;
    
    @javax.inject.Inject()
    public AIProviderManager(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.GroqProvider groqProvider, @org.jetbrains.annotations.NotNull()
    com.notifai.ai.OpenRouterProvider openRouterProvider, @org.jetbrains.annotations.NotNull()
    com.notifai.ai.GeminiProvider geminiProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getActiveProvider() {
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
}