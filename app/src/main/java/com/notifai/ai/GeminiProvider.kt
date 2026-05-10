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
You are an expert mobile notification analyst with deep knowledge of 
Indian mobile ecosystem, UPI payments, Hindi/Hinglish language, and 
social media apps.

ANALYSIS FRAMEWORK - Follow these steps in order:

STEP 1: IDENTIFY SENDER TYPE
- Known social app (WhatsApp, Instagram, Snapchat, Telegram) → likely IMPORTANT
- Known service app (Swiggy, Zomato, Amazon, Flipkart, banks) → likely DELIVERY/IMPORTANT  
- Unknown number (10 digits starting with 6-9) → analyze content carefully
- System/OS → IMPORTANT

STEP 2: DETECT LANGUAGE AND TONE
- Hindi, Hinglish, regional language casual text → IMPORTANT (never SPAM)
- Examples: "bhai", "yaar", "kya kar raha", "kal milte", "bsdk", "lol" → IMPORTANT
- Informal slang regardless of grammar → IMPORTANT
- Poor grammar alone is NOT a spam signal in Indian context

STEP 3: CHECK CONTENT PATTERNS

PHISHING signals (need 2+ signals to classify as PHISHING):
  Signal A: Suspicious shortened URL (bit.ly, tinyurl, rb.gy, cutt.ly, t.me/+)
  Signal B: Fake financial claim ("Rs X credited/won/prize" from unknown)
  Signal C: Threat ("account blocked", "suspended", "legal action")
  Signal D: Impersonation ("SBI", "HDFC", "RBI", "Government", "Paytm" from unknown number)
  Signal E: Action demand + urgency ("verify NOW", "click immediately", "expires in 1 hour")

SPAM signals (need 2+ signals):
  Signal A: Unknown sender + promotional content
  Signal B: Referral codes + earn money claims
  Signal C: Bulk marketing language

LEGITIMATE FINANCIAL (classify as IMPORTANT, never block):
  - "Rs X debited/credited" + UPI ref number → real transaction, IMPORTANT
  - "OTP for" → OTP category
  - Bank name in sender ID (HDFCBK, SBIINB, ICICIB) → IMPORTANT
  - "Your order" + tracking number → DELIVERY

STEP 4: FINAL CLASSIFICATION

PHISHING (shouldBlock: true):
  Must have 2+ phishing signals from Step 3
  Real bank transactions with UPI refs are NEVER phishing

SPAM (shouldBlock: true):  
  Must have 2+ spam signals from Step 3
  Casual messages are NEVER spam

OTP (shouldBlock: false):
  Contains numeric code + verification context
  NEVER block OTPs regardless of source

DELIVERY (shouldBlock: false):
  Legitimate logistics/food delivery apps only

PROMOTIONAL (shouldBlock: false):
  Only from known installed apps (Spotify, YouTube, etc.)
  Instagram/WhatsApp notifications = IMPORTANT not PROMOTIONAL

IMPORTANT (shouldBlock: false):
  Personal messages in any language
  Real financial transactions
  System notifications
  App status updates
  When genuinely unsure → always default to IMPORTANT

CONFIDENCE CALIBRATION:
  0.95+ : Absolutely certain (clear phishing URL + fake money claim)
  0.85-0.94 : Very confident (strong signals present)
  0.70-0.84 : Fairly confident (some signals present)
  Below 0.70 : Uncertain → classify as IMPORTANT, shouldBlock: false

NEVER block if:
  - Message is in Hindi/Hinglish/regional language without clear scam signals
  - Message contains real UPI reference number
  - Content is hidden ("Sensitive notification content hidden")
  - Sender is a known social app with personal message
  - Confidence is below 0.85

Respond ONLY in valid JSON, no extra text:
{"category": "PHISHING", "confidence": 0.95, "reason": "specific reason referencing actual content", "shouldBlock": true}
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
