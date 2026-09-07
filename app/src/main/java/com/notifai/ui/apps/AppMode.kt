package com.notifai.ui.apps

enum class AppMode {
    AUTO,
    ALWAYS_ALLOW,
    ALWAYS_BLOCK;

    companion object {
        fun fromString(value: String?): AppMode =
            entries.firstOrNull { it.name == value } ?: AUTO
    }
}
