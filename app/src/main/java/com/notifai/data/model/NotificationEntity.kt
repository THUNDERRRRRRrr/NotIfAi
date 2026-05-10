package com.notifai.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

/** Room TypeConverter for the [Category] enum. */
class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(value: String): Category =
        runCatching { Category.valueOf(value) }.getOrDefault(Category.UNKNOWN)
}

@Entity(tableName = "notifications")
@TypeConverters(CategoryConverter::class)
data class NotificationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,

    @ColumnInfo(name = "package_name") val packageName: String,
    @ColumnInfo(name = "app_name")     val appName: String,
    @ColumnInfo(name = "title")        val title: String,
    @ColumnInfo(name = "body")         val body: String,
    @ColumnInfo(name = "category")     val category: Category,
    @ColumnInfo(name = "confidence")   val confidence: Float,
    @ColumnInfo(name = "reason")       val reason: String,
    @ColumnInfo(name = "timestamp")    val timestamp: Long,
    @ColumnInfo(name = "is_blocked")   val isBlocked: Boolean,
    @ColumnInfo(name = "ai_provider")  val aiProvider: String,
)
