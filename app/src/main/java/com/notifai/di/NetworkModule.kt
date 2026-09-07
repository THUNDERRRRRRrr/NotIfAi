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

                val key = apiKeyManager.getGroqKey() ?: ""
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $key")
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

    @Provides @Singleton
    @Named("openrouter")
    fun provideOpenRouterOkHttp(apiKeyManager: ApiKeyManager): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->

                val key = apiKeyManager.getOpenRouterKey() ?: ""
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $key")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("HTTP-Referer", "com.notifai")
                    .addHeader("X-Title", "NotifAI")
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

    @Provides @Singleton
    @Named("openai")
    fun provideOpenAiOkHttp(apiKeyManager: ApiKeyManager): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val key = apiKeyManager.getOpenAiKey() ?: ""
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $key")
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

    @Provides @Singleton
    @Named("custom")
    fun provideCustomOkHttp(apiKeyManager: ApiKeyManager): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val key = apiKeyManager.getCustomKey()
                val requestBuilder = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                if (!key.isNullOrBlank()) {
                    requestBuilder.addHeader("Authorization", "Bearer $key")
                }
                chain.proceed(requestBuilder.build())
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

    @Provides @Singleton
    @Named("gemini")
    fun provideGeminiOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
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
    fun provideOpenAiService(@Named("openai") okHttpClient: OkHttpClient, gson: Gson): com.notifai.ai.OpenAIService =
        Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(com.notifai.ai.OpenAIService::class.java)

    @Provides @Singleton
    fun provideCustomService(@Named("custom") okHttpClient: OkHttpClient, gson: Gson): com.notifai.ai.CustomService =
        Retrofit.Builder()
            .baseUrl("https://localhost/") // Base URL ignored because we use @Url in the service
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(com.notifai.ai.CustomService::class.java)

    @Provides @Singleton
    fun provideGeminiService(@Named("gemini") okHttpClient: OkHttpClient, gson: Gson): GeminiService =
        Retrofit.Builder()
            .baseUrl("https://generativelanguage.googleapis.com/v1beta/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GeminiService::class.java)
}

