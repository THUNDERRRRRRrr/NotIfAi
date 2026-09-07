package com.notifai.ai

import com.google.gson.Gson
import com.notifai.ai.model.*
import com.notifai.data.model.AIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

interface OpenAIService {
    @POST("chat/completions")
    suspend fun createChatCompletion(@Body request: OpenAIRequest): Response<OpenAIResponse>
}

@Singleton
class OpenAIProvider @Inject constructor(
    private val openAiService: OpenAIService,
    private val apiKeyManager: ApiKeyManager,
    private val gson: Gson,
) {
    suspend fun classify(appName: String, title: String, body: String): AIResponse {
        if (apiKeyManager.getOpenAiKey().isNullOrBlank()) {
            throw OpenAIException("Missing or empty OpenAI API key")
        }

        val systemPrompt = AIPrompt.getSystemPrompt(appName).trimIndent()

        val userPrompt = "App: $appName\nTitle: $title\nBody: $body"

        val request = OpenAIRequest(
            model = apiKeyManager.getAIModelPreferences().openAiModel,
            messages = listOf(
                OpenAIMessage(role = "system", content = systemPrompt),
                OpenAIMessage(role = "user", content = userPrompt)
            ),
            responseFormat = ResponseFormat(type = "json_object"),
            temperature = 0.0f
        )

        try {
            val response = openAiService.createChatCompletion(request)
            if (!response.isSuccessful) {
                val errorBody = response.errorBody()?.string() ?: "no body"
                if (response.code() == 429) {
                    throw OpenAIException("Rate limit exceeded (429): $errorBody")
                }
                throw OpenAIException("API Error ${response.code()}: $errorBody")
            }

            val content = response.body()?.choices?.firstOrNull()?.message?.content
                ?: throw OpenAIException("Empty response body or content")

            val cleanContent = content.replace(Regex("```(?:json)?\\s*"), "").replace(Regex("\\s*```"), "").trim()
            return gson.fromJson(cleanContent, AIResponse::class.java)
        } catch (e: Exception) {
            if (e is kotlinx.coroutines.CancellationException) throw e
            if (e is OpenAIException) throw e
            throw OpenAIException("Network or parsing error: ${e.message}")
        }
    }
}

class OpenAIException(message: String) : Exception(message)
