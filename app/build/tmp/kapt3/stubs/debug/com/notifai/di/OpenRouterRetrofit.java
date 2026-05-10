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

@javax.inject.Qualifier()
@kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.BINARY)
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/notifai/di/OpenRouterRetrofit;", "", "app_debug"})
public abstract @interface OpenRouterRetrofit {
}