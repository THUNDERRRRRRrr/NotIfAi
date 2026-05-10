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
    private val apiKeyManager: ApiKeyManager,
    private val gson: Gson,
) {
    suspend fun classify(appName: String, title: String, body: String): AIResponse {
        val systemPrompt = """
You are a mobile notification security expert. 
CONTENT always overrides SENDER when classifying.

STEP 1 - Check for PHISHING/SPAM signals first:
- Any shortened URL (bit.ly, tinyurl, rb.gy, cutt.ly, t.me, short.gg)
- Money words + action required: "credited", "debited", "transfer" + "click/verify/confirm"  
- Urgency tactics: "account blocked", "KYC", "verify now", "expire"
- Fake rewards: "won", "prize", "lottery", "selected"
- Grammar errors + financial claims

STEP 2 - If ANY of the above found → PHISHING or SPAM regardless of sender app
Even if sender is WhatsApp, Messages, Telegram — content determines category.

STEP 3 - Only if no suspicious signals found, classify normally:
- OTP: 4-8 digit code + verification words
- DELIVERY: Legitimate courier tracking only
- PROMOTIONAL: Known brand marketing
- IMPORTANT: Clean personal messages, system notifications

EXAMPLES:
"Rs 10000 credited click bit.ly" from Messages → PHISHING (shouldBlock: true)
"Click link to verify KYC" from WhatsApp → PHISHING (shouldBlock: true)  
"Hey are you coming tonight?" from Messages → IMPORTANT (shouldBlock: false)
"Your OTP is 4829" from Messages → OTP (shouldBlock: false)
"Order shipped" from Flipkart → DELIVERY (shouldBlock: false)

Respond ONLY in valid JSON:
{"category": "string", "confidence": 0.0-1.0, "reason": "one sentence", "shouldBlock": true/false}
""".trimIndent()

        val userPrompt = "App: $appName\nTitle: $title\nBody: $body"

        val request = OpenAIRequest(
            model = apiKeyManager.getAIModelPreferences().groqModel,
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
