package com.notifai.ui.settings

enum class SensitivityLevel {
    AGGRESSIVE,
    BALANCED,
    RELAXED;

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
