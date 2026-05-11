package com.notifai.data.model

data class AIModelPreferences(
    val confidenceThreshold: Float = 0.75f,
    val enableCascading: Boolean = true,
    val groqModel: String = "llama-3.3-70b-versatile",
    val openRouterModel: String = "meta-llama/llama-3.1-8b-instruct:free",
    val cascadeOrder: List<String> = listOf("gemini", "groq", "openrouter"),
)
