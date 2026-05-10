package com.notifai.ai;

import com.google.gson.Gson;
import com.notifai.ai.model.*;
import com.notifai.data.model.AIResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/notifai/ai/GroqService;", "", "createChatCompletion", "Lretrofit2/Response;", "Lcom/notifai/ai/model/OpenAIResponse;", "request", "Lcom/notifai/ai/model/OpenAIRequest;", "(Lcom/notifai/ai/model/OpenAIRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface GroqService {
    
    @retrofit2.http.POST(value = "openai/v1/chat/completions")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createChatCompletion(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.notifai.ai.model.OpenAIRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.notifai.ai.model.OpenAIResponse>> $completion);
}