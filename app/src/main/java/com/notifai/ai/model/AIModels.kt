package com.notifai.ai.model

import com.google.gson.annotations.SerializedName

// Exceptions
class GroqException(message: String) : Exception(message)
class OpenRouterException(message: String) : Exception(message)
class GeminiException(message: String) : Exception(message)

// OpenAI Compatible Models (Groq, OpenRouter)
data class OpenAIRequest(
    @SerializedName("model") val model: String,
    @SerializedName("messages") val messages: List<OpenAIMessage>,
    @SerializedName("response_format") val responseFormat: ResponseFormat? = null,
    @SerializedName("temperature") val temperature: Float? = null
)

data class OpenAIMessage(
    @SerializedName("role") val role: String,
    @SerializedName("content") val content: String
)

data class ResponseFormat(
    @SerializedName("type") val type: String
)

data class OpenAIResponse(
    @SerializedName("choices") val choices: List<OpenAIChoice>?
)

data class OpenAIChoice(
    @SerializedName("message") val message: OpenAIMessage?
)

// Gemini Models
data class GeminiRequest(
    @SerializedName("system_instruction") val systemInstruction: GeminiContent?,
    @SerializedName("contents") val contents: List<GeminiContent>,
    @SerializedName("generationConfig") val generationConfig: GeminiGenerationConfig? = null
)

data class GeminiGenerationConfig(
    @SerializedName("responseMimeType") val responseMimeType: String? = null
)

data class GeminiContent(
    @SerializedName("role") val role: String?,
    @SerializedName("parts") val parts: List<GeminiPart>
)

data class GeminiPart(
    @SerializedName("text") val text: String
)

data class GeminiResponse(
    @SerializedName("candidates") val candidates: List<GeminiCandidate>?
)

data class GeminiCandidate(
    @SerializedName("content") val content: GeminiContent?
)
