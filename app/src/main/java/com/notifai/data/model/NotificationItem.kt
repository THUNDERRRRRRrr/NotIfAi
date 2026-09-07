package com.notifai.data.model

data class NotificationItem(
    val id: Long,
    val packageName: String,
    val appName: String,
    val title: String,
    val body: String,
    val category: Category,
    val confidence: Float,
    val reason: String,
    val timestamp: Long,
    val isBlocked: Boolean,
    val aiProvider: String,
)

fun NotificationEntity.toNotificationItem(): NotificationItem = NotificationItem(
    id = id,
    packageName = packageName,
    appName = appName,
    title = title,
    body = body,
    category = category,
    confidence = confidence,
    reason = reason,
    timestamp = timestamp,
    isBlocked = isBlocked,
    aiProvider = aiProvider,
)

fun NotificationItem.toEntity(): NotificationEntity = NotificationEntity(
    id = id,
    packageName = packageName,
    appName = appName,
    title = title,
    body = body,
    category = category,
    confidence = confidence,
    reason = reason,
    timestamp = timestamp,
    isBlocked = isBlocked,
    aiProvider = aiProvider,
)
