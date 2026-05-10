package com.notifai.di

import android.content.Context
import androidx.room.Room
import com.notifai.data.db.NotificationDao
import com.notifai.data.db.NotificationDatabase
import com.notifai.data.repository.NotificationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module that wires the entire data layer into the DI graph.
 *
 * All bindings are [Singleton] so that the database connection and
 * repository state are shared across the whole application lifetime,
 * including the [com.notifai.service.NotifListenerService].
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotificationDatabase(
        @ApplicationContext context: Context,
    ): NotificationDatabase =
        Room.databaseBuilder(
            context,
            NotificationDatabase::class.java,
            "notifai.db",
        )
            .fallbackToDestructiveMigration()   // replace with explicit Migrations pre-release
            .build()

    @Provides
    @Singleton
    fun provideNotificationDao(
        database: NotificationDatabase,
    ): NotificationDao = database.notificationDao()

    @Provides
    @Singleton
    fun provideNotificationRepository(
        dao: NotificationDao,
    ): NotificationRepository = NotificationRepository(dao)
}
