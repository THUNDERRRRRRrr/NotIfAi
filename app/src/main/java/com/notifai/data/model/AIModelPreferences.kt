package com.notifai.data.model

data class AIModelPreferences(
    val confidenceThreshold: Float = 0.75f,
    val enableCascading: Boolean = true,
    val groqModel: String = "llama-3.3-70b-versatile",
    val openRouterModel: String = "openrouter/auto",
    val cascadeOrder: List<String> = listOf("groq", "openrouter", "gemini"),
)
