package com.notifai.ui.apps

/**
 * Per-app override for the notification filter.
 *
 * - [AUTO]         — let the AI decide (default)
 * - [ALWAYS_ALLOW] — never block notifications from this app
 * - [ALWAYS_BLOCK] — always block notifications from this app
 */
enum class AppMode {
    AUTO,
    ALWAYS_ALLOW,
    ALWAYS_BLOCK;

    companion object {
        fun fromString(value: String?): AppMode =
            entries.firstOrNull { it.name == value } ?: AUTO
    }
}
