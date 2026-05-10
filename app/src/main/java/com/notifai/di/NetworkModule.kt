package com.notifai.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.notifai.ai.ApiKeyManager
import com.notifai.ai.GeminiService
import com.notifai.ai.GroqService
import com.notifai.ai.OpenRouterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides @Singleton
    @Named("groq")
    fun provideGroqOkHttp(apiKeyManager: ApiKeyManager): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${apiKeyManager.getGroqKey() ?: ""}")
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides @Singleton
    @Named("openrouter")
    fun provideOpenRouterOkHttp(apiKeyManager: ApiKeyManager): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${apiKeyManager.getOpenRouterKey() ?: ""}")
                    .addHeader("HTTP-Referer", "com.notifai")
                    .addHeader("X-Title", "NotifAI")
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides @Singleton
    @Named("gemini")
    fun provideGeminiOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides @Singleton
    fun provideGroqService(@Named("groq") okHttpClient: OkHttpClient, gson: Gson): GroqService =
        Retrofit.Builder()
            .baseUrl("https://api.groq.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GroqService::class.java)

    @Provides @Singleton
    fun provideOpenRouterService(@Named("openrouter") okHttpClient: OkHttpClient, gson: Gson): OpenRouterService =
        Retrofit.Builder()
            .baseUrl("https://openrouter.ai/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(OpenRouterService::class.java)

    @Provides @Singleton
    fun provideGeminiService(@Named("gemini") okHttpClient: OkHttpClient, gson: Gson): GeminiService =
        Retrofit.Builder()
            .baseUrl("https://generativelanguage.googleapis.com/v1beta/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GeminiService::class.java)
}
