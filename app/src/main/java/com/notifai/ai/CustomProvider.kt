package com.notifai.ai

import com.google.gson.Gson
import com.notifai.ai.model.*
import com.notifai.data.model.AIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url
import javax.inject.Inject
import javax.inject.Singleton

interface CustomService {
    @POST
    suspend fun createChatCompletion(@Url url: String, @Body request: OpenAIRequest): Response<OpenAIResponse>
}

class CustomException(message: String) : Exception(message)

@Singleton
class CustomProvider @Inject constructor(
    private val customService: CustomService,
    private val apiKeyManager: ApiKeyManager,
    private val gson: Gson,
) {
    suspend fun classify(appName: String, title: String, body: String): AIResponse {
        val url = apiKeyManager.getCustomUrl()
        if (url.isNullOrBlank()) {
            throw CustomException("Missing Custom API URL")
        }
        
        // We will just let Retrofit use the interceptor for the API key,
        // but we need to check if we should even proceed.
        // Actually, some local APIs don't need a key, so we won't strictly require it.
        
        val systemPrompt = AIPrompt.getSystemPrompt(appName).trimIndent()

        val userPrompt = "App: $appName\nTitle: $title\nBody: $body"

        val request = OpenAIRequest(
            model = apiKeyManager.getAIModelPreferences().customModel,
            messages = listOf(
                OpenAIMessage(role = "system", content = systemPrompt),
                OpenAIMessage(role = "user", content = userPrompt)
            ),
            responseFormat = ResponseFormat(type = "json_object"),
            temperature = 0.0f
        )

        try {
            val response = customService.createChatCompletion(url, request)
            if (!response.isSuccessful) {
                val errorBody = response.errorBody()?.string() ?: "no body"
                if (response.code() == 429) {
                    throw CustomException("Rate limit exceeded (429): $errorBody")
                }
                throw CustomException("API Error ${response.code()}: $errorBody")
            }

            val content = response.body()?.choices?.firstOrNull()?.message?.content
                ?: throw CustomException("Empty response body or content")

            val cleanContent = content.replace(Regex("```(?:json)?\\s*"), "").replace(Regex("\\s*```"), "").trim()
            return gson.fromJson(cleanContent, AIResponse::class.java)
        } catch (e: Exception) {
            if (e is kotlinx.coroutines.CancellationException) throw e
            if (e is CustomException) throw e
            throw CustomException("Network or parsing error: ${e.message}")
        }
    }
}
