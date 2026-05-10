package com.notifai.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.notifai.ai.ApiKeyManager
import com.notifai.ai.GeminiService
import com.notifai.ai.GroqService
import com.notifai.ai.OpenRouterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GroqRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OpenRouterRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GeminiRetrofit

@Module
@InstallIn(SingletonComponent::class)
object AIModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    @GroqRetrofit
    fun provideGroqOkHttpClient(apiKeyManager: ApiKeyManager): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                apiKeyManager.getGroqKey()?.let { key ->
                    request.addHeader("Authorization", "Bearer $key")
                }
                chain.proceed(request.build())
            }
            .build()
    }

    @Provides
    @Singleton
    @GroqRetrofit
    fun provideGroqRetrofit(@GroqRetrofit okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.groq.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideGroqService(@GroqRetrofit retrofit: Retrofit): GroqService {
        return retrofit.create(GroqService::class.java)
    }

    @Provides
    @Singleton
    @OpenRouterRetrofit
    fun provideOpenRouterOkHttpClient(apiKeyManager: ApiKeyManager): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                apiKeyManager.getOpenRouterKey()?.let { key ->
                    request.addHeader("Authorization", "Bearer $key")
                }
                request.addHeader("HTTP-Referer", "com.notifai")
                request.addHeader("X-Title", "NotifAI")
                chain.proceed(request.build())
            }
            .build()
    }

    @Provides
    @Singleton
    @OpenRouterRetrofit
    fun provideOpenRouterRetrofit(@OpenRouterRetrofit okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://openrouter.ai/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideOpenRouterService(@OpenRouterRetrofit retrofit: Retrofit): OpenRouterService {
        return retrofit.create(OpenRouterService::class.java)
    }

    @Provides
    @Singleton
    @GeminiRetrofit
    fun provideGeminiOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    @GeminiRetrofit
    fun provideGeminiRetrofit(@GeminiRetrofit okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://generativelanguage.googleapis.com/v1beta/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideGeminiService(@GeminiRetrofit retrofit: Retrofit): GeminiService {
        return retrofit.create(GeminiService::class.java)
    }
}
