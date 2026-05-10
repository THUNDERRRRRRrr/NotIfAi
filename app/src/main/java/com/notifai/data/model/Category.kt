package com.notifai.data.model

/**
 * AI-assigned category for a notification.
 * Used as a Room column (stored as String via [CategoryConverter]).
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
