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
    @POST("models/gemini-2.5-flash:generateContent")
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
        
        val systemPrompt = AIPrompt.SYSTEM_PROMPT.trimIndent()
        
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
                val errorBody = response.errorBody()?.string() ?: "no body"
                throw GeminiException("API Error ${response.code()}: $errorBody")
            }
            
            // Gemini 2.5 Flash is a thinking model — filter out thought parts
            // and grab only the actual answer text
            val parts = response.body()?.candidates?.firstOrNull()?.content?.parts
                ?: throw GeminiException("Empty response body or candidates")

            val content = parts
                .filter { it.thought != true }
                .firstNotNullOfOrNull { it.text }
                ?: throw GeminiException("No non-thought content in response")
                
            val cleanContent = content.replace(Regex("```(?:json)?\\s*"), "").replace(Regex("\\s*```"), "").trim()
            return gson.fromJson(cleanContent, AIResponse::class.java)
        } catch (e: Exception) {
            if (e is kotlinx.coroutines.CancellationException) throw e
            if (e is GeminiException) throw e
            throw GeminiException("Network or parsing error: ${e.message}")
        }
    }
}
