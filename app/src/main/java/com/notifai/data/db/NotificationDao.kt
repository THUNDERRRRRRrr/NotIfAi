package com.notifai.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.notifai.data.model.Category
import com.notifai.data.model.NotificationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotificationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotification(entity: NotificationEntity)

    @Query("UPDATE notifications SET is_blocked = :isBlocked WHERE id = :id")
    suspend fun updateBlockedStatus(id: Long, isBlocked: Boolean)

    @Query("DELETE FROM notifications WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM notifications WHERE timestamp < :timestamp")
    suspend fun deleteNotificationsOlderThan(timestamp: Long)

    @Query("DELETE FROM notifications")
    suspend fun deleteAll()

    @Query("SELECT * FROM notifications ORDER BY timestamp DESC LIMIT :limit")
    fun getRecentNotifications(limit: Int): Flow<List<NotificationEntity>>

    @Query("SELECT * FROM notifications ORDER BY timestamp DESC")
    fun getAllNotifications(): Flow<List<NotificationEntity>>

    @Query("SELECT * FROM notifications WHERE is_blocked = 1 ORDER BY timestamp DESC")
    fun getBlockedNotifications(): Flow<List<NotificationEntity>>

    @Query("SELECT * FROM notifications WHERE is_blocked = 0 ORDER BY timestamp DESC")
    fun getAllowedNotifications(): Flow<List<NotificationEntity>>

    @Query("SELECT * FROM notifications WHERE category = :category ORDER BY timestamp DESC")
    fun getNotificationsByCategory(category: Category): Flow<List<NotificationEntity>>

    @Query(
        """
        SELECT COUNT(*) FROM notifications
        WHERE is_blocked = 1
          AND timestamp >= :startOfDay
        """
    )
    fun getTodayBlockedCount(startOfDay: Long): Flow<Int>

    @Query(
        """
        SELECT COUNT(*) FROM notifications
        WHERE category = :category
          AND timestamp >= :startOfDay
        """
    )
    fun getTodayCountByCategory(category: Category, startOfDay: Long): Flow<Int>
}
