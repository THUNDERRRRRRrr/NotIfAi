package com.notifai.ai

import com.google.gson.Gson
import com.notifai.ai.model.*
import com.notifai.data.model.AIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

interface GroqService {
    @POST("openai/v1/chat/completions")
    suspend fun createChatCompletion(@Body request: OpenAIRequest): Response<OpenAIResponse>
}

@Singleton
class GroqProvider @Inject constructor(
    private val groqService: GroqService,
    private val gson: Gson
) {
    suspend fun classify(appName: String, title: String, body: String): AIResponse {
        val systemPrompt = """
            You are a notification spam classifier. Classify into: 
            OTP, DELIVERY, PROMOTIONAL, SPAM, PHISHING, IMPORTANT.
            Respond ONLY with valid JSON, no markdown:
            {"category": "UNKNOWN", "confidence": 0.0, "reason": "...", "should_block": false}
        """.trimIndent()
        
        val userPrompt = "App: $appName\nTitle: $title\nBody: $body"
        
        val request = OpenAIRequest(
            model = "llama-3.1-8b-instant",
            messages = listOf(
                OpenAIMessage(role = "system", content = systemPrompt),
                OpenAIMessage(role = "user", content = userPrompt)
            ),
            responseFormat = ResponseFormat(type = "json_object"),
            temperature = 0.0f
        )
        
        try {
            val response = groqService.createChatCompletion(request)
            if (!response.isSuccessful) {
                if (response.code() == 429) {
                    throw GroqException("Rate limit exceeded (429)")
                }
                throw GroqException("API Error: ${response.code()} ${response.message()}")
            }
            
            val content = response.body()?.choices?.firstOrNull()?.message?.content
                ?: throw GroqException("Empty response body or content")
                
            return gson.fromJson(content, AIResponse::class.java)
        } catch (e: Exception) {
            if (e is kotlinx.coroutines.CancellationException) throw e
            if (e is GroqException) throw e
            throw GroqException("Network or parsing error: ${e.message}")
        }
    }
}
