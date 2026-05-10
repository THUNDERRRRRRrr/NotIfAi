package com.notifai.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

/**
 * Room TypeConverter for the [Category] enum.
 * Persists the enum as its [name] string so the column remains human-readable
 * and is resilient to reordering of enum entries.
 */
class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(value: String): Category =
        runCatching { Category.valueOf(value) }.getOrDefault(Category.UNKNOWN)
}

/**
 * Represents a single intercepted notification stored in the local Room database.
 *
 * @property id          Auto-generated primary key.
 * @property packageName Package identifier of the source app (e.g. "com.whatsapp").
 * @property appName     Human-readable app label.
 * @property title       Notification title text.
 * @property body        Notification body / content text.
 * @property category    AI-assigned [Category].
 * @property confidence  Confidence score returned by the AI provider (0.0 – 1.0).
 * @property reason      Short natural-language explanation from the AI.
 * @property timestamp   Unix epoch milliseconds when the notification was received.
 * @property isBlocked   Whether the notification was suppressed by the filter.
 * @property aiProvider  Identifier of the provider that classified this notification
 *                       ("groq", "openrouter", or "gemini").
 */
@Entity(tableName = "notifications")
@TypeConverters(CategoryConverter::class)
data class NotificationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,

    @ColumnInfo(name = "package_name")
    val packageName: String,

    @ColumnInfo(name = "app_name")
    val appName: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "body")
    val body: String,

    /** Stored as a String via [CategoryConverter]. */
    @ColumnInfo(name = "category")
    val category: Category,

    @ColumnInfo(name = "confidence")
    val confidence: Float,

    @ColumnInfo(name = "reason")
    val reason: String,

    @ColumnInfo(name = "timestamp")
    val timestamp: Long,

    @ColumnInfo(name = "is_blocked")
    val isBlocked: Boolean,

    @ColumnInfo(name = "ai_provider")
    val aiProvider: String,
)
