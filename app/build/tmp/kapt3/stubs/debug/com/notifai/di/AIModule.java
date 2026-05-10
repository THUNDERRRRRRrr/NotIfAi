package com.notifai.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.notifai.ai.ApiKeyManager;
import com.notifai.ai.GeminiService;
import com.notifai.ai.GroqService;
import com.notifai.ai.OpenRouterService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Qualifier;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u001a\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\f\u001a\u00020\u0006H\u0007J\b\u0010\u0013\u001a\u00020\tH\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\f\u001a\u00020\u0006H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/notifai/di/AIModule;", "", "()V", "provideGeminiOkHttpClient", "Lokhttp3/OkHttpClient;", "provideGeminiRetrofit", "Lretrofit2/Retrofit;", "okHttpClient", "gson", "Lcom/google/gson/Gson;", "provideGeminiService", "Lcom/notifai/ai/GeminiService;", "retrofit", "provideGroqOkHttpClient", "apiKeyManager", "Lcom/notifai/ai/ApiKeyManager;", "provideGroqRetrofit", "provideGroqService", "Lcom/notifai/ai/GroqService;", "provideGson", "provideOpenRouterOkHttpClient", "provideOpenRouterRetrofit", "provideOpenRouterService", "Lcom/notifai/ai/OpenRouterService;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AIModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.di.AIModule INSTANCE = null;
    
    private AIModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @GroqRetrofit()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideGroqOkHttpClient(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.ApiKeyManager apiKeyManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @GroqRetrofit()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideGroqRetrofit(@GroqRetrofit()
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.ai.GroqService provideGroqService(@GroqRetrofit()
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @OpenRouterRetrofit()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOpenRouterOkHttpClient(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.ApiKeyManager apiKeyManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @OpenRouterRetrofit()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideOpenRouterRetrofit(@OpenRouterRetrofit()
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.ai.OpenRouterService provideOpenRouterService(@OpenRouterRetrofit()
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @GeminiRetrofit()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideGeminiOkHttpClient() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @GeminiRetrofit()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideGeminiRetrofit(@GeminiRetrofit()
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.ai.GeminiService provideGeminiService(@GeminiRetrofit()
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
}