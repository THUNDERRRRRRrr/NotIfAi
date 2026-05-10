package com.notifai.di;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.notifai.ai.ApiKeyManager;
import com.notifai.ai.GeminiService;
import com.notifai.ai.GroqService;
import com.notifai.ai.OpenRouterService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u001a\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\u000f\u001a\u00020\tH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/notifai/di/NetworkModule;", "", "()V", "provideGeminiOkHttp", "Lokhttp3/OkHttpClient;", "provideGeminiService", "Lcom/notifai/ai/GeminiService;", "okHttpClient", "gson", "Lcom/google/gson/Gson;", "provideGroqOkHttp", "apiKeyManager", "Lcom/notifai/ai/ApiKeyManager;", "provideGroqService", "Lcom/notifai/ai/GroqService;", "provideGson", "provideOpenRouterOkHttp", "provideOpenRouterService", "Lcom/notifai/ai/OpenRouterService;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
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
    @javax.inject.Named(value = "groq")
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideGroqOkHttp(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.ApiKeyManager apiKeyManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @javax.inject.Named(value = "openrouter")
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOpenRouterOkHttp(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.ApiKeyManager apiKeyManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @javax.inject.Named(value = "gemini")
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideGeminiOkHttp() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.ai.GroqService provideGroqService(@javax.inject.Named(value = "groq")
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.ai.OpenRouterService provideOpenRouterService(@javax.inject.Named(value = "openrouter")
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.ai.GeminiService provideGeminiService(@javax.inject.Named(value = "gemini")
    @org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
}