package com.notifai.ai

import com.google.gson.Gson
import com.notifai.ai.model.*
import com.notifai.data.model.AIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

interface OpenRouterService {
    @POST("api/v1/chat/completions")
    suspend fun createChatCompletion(@Body request: OpenAIRequest): Response<OpenAIResponse>
}

@Singleton
class OpenRouterProvider @Inject constructor(
    private val openRouterService: OpenRouterService,
    private val apiKeyManager: ApiKeyManager,
    private val gson: Gson,
) {
    suspend fun classify(appName: String, title: String, body: String): AIResponse {
        if (apiKeyManager.getOpenRouterKey().isNullOrBlank()) {
            throw OpenRouterException("Missing or empty OpenRouter API key")
        }

        val systemPrompt = AIPrompt.SYSTEM_PROMPT.trimIndent()

        val userPrompt = "App: $appName\nTitle: $title\nBody: $body"

        val request = OpenAIRequest(
            model = apiKeyManager.getAIModelPreferences().openRouterModel,
            messages = listOf(
                OpenAIMessage(role = "system", content = systemPrompt),
                OpenAIMessage(role = "user", content = userPrompt)
            ),
            responseFormat = ResponseFormat(type = "json_object"),
            temperature = 0.0f
        )

        try {
            val response = openRouterService.createChatCompletion(request)
            if (!response.isSuccessful) {
                val errorBody = response.errorBody()?.string() ?: "no body"
                throw OpenRouterException("API Error ${response.code()}: $errorBody")
            }

            val content = response.body()?.choices?.firstOrNull()?.message?.content
                ?: throw OpenRouterException("Empty response body or content")

            return gson.fromJson(content, AIResponse::class.java)
        } catch (e: Exception) {
            if (e is kotlinx.coroutines.CancellationException) throw e
            if (e is OpenRouterException) throw e
            throw OpenRouterException("Network or parsing error: ${e.message}")
        }
    }
}
