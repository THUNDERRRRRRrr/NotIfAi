package com.notifai.ai

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BlockingEngine @Inject constructor(
    private val apiKeyManager: ApiKeyManager,
) {
    /**
     * Decides whether a notification should be blocked based on the user's
     * per-category preferences and the AI's confidence score.
     */
    fun shouldBlock(category: String, confidence: Float): Boolean {
        val prefs = apiKeyManager.getBlockingPreferences()
        if (confidence < prefs.minConfidenceThreshold) return false
        return when (category.uppercase()) {
            "SPAM"        -> prefs.blockSpam
            "PHISHING"    -> prefs.blockPhishing
            "PROMOTIONAL" -> prefs.blockPromotional
            "UNKNOWN"     -> prefs.blockUnknown
            "DELIVERY"    -> prefs.blockDelivery
            "OTP"         -> prefs.blockOtp
            else          -> false
        }
    }
}
