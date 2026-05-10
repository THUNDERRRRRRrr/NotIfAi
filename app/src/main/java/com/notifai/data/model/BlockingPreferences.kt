package com.notifai.data.model

data class BlockingPreferences(
    val blockSpam: Boolean = true,
    val blockPhishing: Boolean = true,
    val blockPromotional: Boolean = false,
    val blockUnknown: Boolean = false,
    val blockDelivery: Boolean = false,
    val blockOtp: Boolean = false,
    val minConfidenceThreshold: Float = 0.7f,
)
