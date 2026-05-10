package com.notifai.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
    exportSchema = true,
)
@TypeConverters(CategoryConverter::class)
abstract class NotificationDatabase : RoomDatabase() {

    abstract fun notificationDao(): NotificationDao

    companion object {
        private const val DB_NAME = "notifai.db"

        @Volatile
        private var INSTANCE: NotificationDatabase? = null

        fun getInstance(context: Context): NotificationDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    NotificationDatabase::class.java,
                    DB_NAME,
                )
                    .fallbackToDestructiveMigration()   // replace with Migrations before v2
                    .build()
                    .also { INSTANCE = it }
            }
    }
}
