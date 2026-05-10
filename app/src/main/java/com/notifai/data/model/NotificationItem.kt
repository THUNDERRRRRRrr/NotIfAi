package com.notifai.data.model

/**
 * UI-layer representation of a notification. Mirrors [NotificationEntity] but
 * carries no Room annotations so Compose screens stay decoupled from the
 * database layer.
 *
 * Convert from the entity with [NotificationEntity.toNotificationItem].
 */
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

// ── Mapping helpers ───────────────────────────────────────────────────────────

/** Maps a [NotificationEntity] from the database to a [NotificationItem] for the UI. */
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

/** Maps a [NotificationItem] back to a [NotificationEntity] (e.g. for inserts). */
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
