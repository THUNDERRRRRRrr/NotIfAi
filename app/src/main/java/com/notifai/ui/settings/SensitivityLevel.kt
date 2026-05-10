package com.notifai.ui.settings

/**
 * Controls how aggressively NotifAI blocks notifications.
 *
 * - [AGGRESSIVE] — block anything with confidence ≥ 0.6
 * - [BALANCED]   — block anything with confidence ≥ 0.8  (default)
 * - [RELAXED]    — block only high-certainty spam/phishing (confidence ≥ 0.93)
 */
enum class SensitivityLevel {
    AGGRESSIVE,
    BALANCED,
    RELAXED;

    /** Minimum AI confidence score required to block a notification. */
    val confidenceThreshold: Float
        get() = when (this) {
            AGGRESSIVE -> 0.60f
            BALANCED   -> 0.80f
            RELAXED    -> 0.93f
        }

    companion object {
        val DEFAULT = BALANCED

        fun fromString(value: String?): SensitivityLevel =
            entries.firstOrNull { it.name == value } ?: DEFAULT
    }
}
