package com.notifai.ai

import com.google.gson.Gson
import com.notifai.ai.model.*
import com.notifai.data.model.AIResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

interface GeminiService {
    @POST("models/gemini-1.5-flash:generateContent")
    suspend fun generateContent(
        @Query("key") apiKey: String,
        @Body request: GeminiRequest
    ): Response<GeminiResponse>
}

@Singleton
class GeminiProvider @Inject constructor(
    private val geminiService: GeminiService,
    private val apiKeyManager: ApiKeyManager,
    private val gson: Gson
) {
    suspend fun classify(appName: String, title: String, body: String): AIResponse {
        val apiKey = apiKeyManager.getGeminiKey() ?: throw GeminiException("Missing API key")
        
        val systemPrompt = """
            You are a notification spam classifier. Classify into: 
            OTP, DELIVERY, PROMOTIONAL, SPAM, PHISHING, IMPORTANT.
            Respond ONLY with valid JSON, no markdown:
            {"category": "UNKNOWN", "confidence": 0.0, "reason": "...", "should_block": false}
        """.trimIndent()
        
        val userPrompt = "App: $appName\nTitle: $title\nBody: $body"
        
        val request = GeminiRequest(
            systemInstruction = GeminiContent(
                role = null,
                parts = listOf(GeminiPart(text = systemPrompt))
            ),
            contents = listOf(
                GeminiContent(
                    role = "user",
                    parts = listOf(GeminiPart(text = userPrompt))
                )
            ),
            generationConfig = GeminiGenerationConfig(
                responseMimeType = "application/json"
            )
        )
        
        try {
            val response = geminiService.generateContent(apiKey, request)
            if (!response.isSuccessful) {
                throw GeminiException("API Error: ${response.code()} ${response.message()}")
            }
            
            val content = response.body()?.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
                ?: throw GeminiException("Empty response body or content")
                
            return gson.fromJson(content, AIResponse::class.java)
        } catch (e: Exception) {
            if (e is kotlinx.coroutines.CancellationException) throw e
            if (e is GeminiException) throw e
            throw GeminiException("Network or parsing error: ${e.message}")
        }
    }
}
