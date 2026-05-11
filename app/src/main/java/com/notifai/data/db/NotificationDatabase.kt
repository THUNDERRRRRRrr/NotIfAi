package com.notifai.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.notifai.data.model.CategoryConverter
import com.notifai.data.model.NotificationEntity

/**
 * Single Room database for the NotifAI app.
 *
 * Hilt provides this singleton via [com.notifai.di.AppModule]; direct
 * access via [NotificationDatabase.getInstance] is available for contexts
 * that cannot use injection (e.g. instrumented tests).
 */
@Database(
    entities = [NotificationEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(CategoryConverter::class)
abstract class NotificationDatabase : RoomDatabase() {

    abstract fun notificationDao(): NotificationDao
}
