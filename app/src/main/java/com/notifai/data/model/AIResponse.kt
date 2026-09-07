package com.notifai.data.model

import com.google.gson.annotations.SerializedName

data class AIResponse(
    @SerializedName("category")
    val category: String,

    @SerializedName("confidence")
    val confidence: Float,

    @SerializedName("reason")
    val reason: String,

    @SerializedName(value = "shouldBlock", alternate = ["should_block"])
    val shouldBlock: Boolean,

    @SerializedName("senderVerdict")
    val senderVerdict: String? = null,

    @SerializedName("redFlags")
    val redFlags: List<String>? = null,
)
