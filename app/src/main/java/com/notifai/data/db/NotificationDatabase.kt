package com.notifai.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.notifai.data.model.CategoryConverter
import com.notifai.data.model.NotificationEntity

@Database(
    entities = [NotificationEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(CategoryConverter::class)
abstract class NotificationDatabase : RoomDatabase() {

    abstract fun notificationDao(): NotificationDao
}
