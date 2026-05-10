package com.notifai.data.model

/**
 * AI-assigned category for a notification.
 * Stored as its [name] string in Room via [CategoryConverter].
 */
enum class Category {
    OTP,
    DELIVERY,
    PROMOTIONAL,
    SPAM,
    PHISHING,
    IMPORTANT,
    UNKNOWN
}
