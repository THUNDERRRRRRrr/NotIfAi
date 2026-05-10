package com.notifai.ui.apps

import android.graphics.drawable.Drawable

/**
 * UI model for a single installed app shown in the App Settings screen.
 *
 * @property packageName     Unique app identifier (e.g. "com.whatsapp").
 * @property appName         Human-readable app label.
 * @property appIcon         App launcher icon loaded from [PackageManager]; null
 *                           if the icon could not be resolved.
 * @property mode            Current [AppMode] override for this app.
 * @property notificationCount Total notifications captured from this app.
 */
data class AppNotificationSetting(
    val packageName: String,
    val appName: String,
    val appIcon: Drawable?,
    val mode: AppMode,
    val notificationCount: Int,
)
