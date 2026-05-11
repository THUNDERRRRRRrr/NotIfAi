package com.notifai.test

import com.google.gson.GsonBuilder
import com.notifai.ai.model.*

fun main() {
    val gson = GsonBuilder().create()
    val request = GeminiRequest(
        systemInstruction = GeminiContent(
            role = null,
            parts = listOf(GeminiPart(text = "System Prompt"))
        ),
        contents = listOf(
            GeminiContent(
                role = "user",
                parts = listOf(GeminiPart(text = "User Prompt"))
            )
        ),
        generationConfig = GeminiGenerationConfig(
            responseMimeType = "application/json"
        )
    )
    println(gson.toJson(request))
}
