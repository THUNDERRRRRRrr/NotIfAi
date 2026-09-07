package com.notifai.ui.apps

import android.graphics.drawable.Drawable

data class AppNotificationSetting(
    val packageName: String,
    val appName: String,
    val appIcon: Drawable?,
    val mode: AppMode,
    val notificationCount: Int,
)
