package com.notifai.ai;

import com.google.gson.Gson;
import com.notifai.ai.model.*;
import com.notifai.data.model.AIResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/notifai/ai/GroqProvider;", "", "groqService", "Lcom/notifai/ai/GroqService;", "apiKeyManager", "Lcom/notifai/ai/ApiKeyManager;", "gson", "Lcom/google/gson/Gson;", "(Lcom/notifai/ai/GroqService;Lcom/notifai/ai/ApiKeyManager;Lcom/google/gson/Gson;)V", "classify", "Lcom/notifai/data/model/AIResponse;", "appName", "", "title", "body", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GroqProvider {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.GroqService groqService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.ai.ApiKeyManager apiKeyManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    @javax.inject.Inject()
    public GroqProvider(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.GroqService groqService, @org.jetbrains.annotations.NotNull()
    com.notifai.ai.ApiKeyManager apiKeyManager, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object classify(@org.jetbrains.annotations.NotNull()
    java.lang.String appName, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.notifai.data.model.AIResponse> $completion) {
        return null;
    }
}