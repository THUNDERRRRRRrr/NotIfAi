package com.notifai.data.model

import com.google.gson.annotations.SerializedName

/**
 * Represents the JSON payload returned by any AI provider after classifying
 * a notification.
 *
 * Expected JSON shape:
 * ```json
 * {
 *   "category":    "OTP",
 *   "confidence":  0.97,
 *   "reason":      "Contains a 6-digit one-time password.",
 *   "shouldBlock": false
 * }
 * ```
 */
data class AIResponse(
    @SerializedName("category")
    val category: String,

    @SerializedName("confidence")
    val confidence: Float,

    @SerializedName("reason")
    val reason: String,

    @SerializedName(value = "shouldBlock", alternate = ["should_block"])
    val shouldBlock: Boolean,
)
