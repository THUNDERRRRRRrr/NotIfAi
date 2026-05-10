package com.notifai.data.repository

import com.notifai.data.db.NotificationDao
import com.notifai.data.model.Category
import com.notifai.data.model.DashboardStats
import com.notifai.data.model.NotificationEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Single source of truth for notification data.
 * ViewModels and Services interact only with this class, never with the DAO directly.
 */
@Singleton
class NotificationRepository @Inject constructor(
    private val dao: NotificationDao,
) {

    // ── Writes ────────────────────────────────────────────────────────────────

    suspend fun saveNotification(entity: NotificationEntity) =
        dao.insertNotification(entity)

    suspend fun unblockNotification(id: Long) =
        dao.updateBlockedStatus(id, isBlocked = false)

    suspend fun deleteNotification(id: Long) =
        dao.deleteById(id)

    suspend fun pruneOlderThan(timestamp: Long) =
        dao.deleteNotificationsOlderThan(timestamp)

    suspend fun clearAll() = dao.deleteAll()

    // ── Reads ─────────────────────────────────────────────────────────────────

    fun getAllNotifications(): Flow<List<NotificationEntity>> =
        dao.getAllNotifications()

    fun getBlockedNotifications(): Flow<List<NotificationEntity>> =
        dao.getBlockedNotifications()

    fun getAllowedNotifications(): Flow<List<NotificationEntity>> =
        dao.getAllowedNotifications()

    fun getNotificationsByCategory(category: Category): Flow<List<NotificationEntity>> =
        dao.getNotificationsByCategory(category)

    // ── Dashboard stats ───────────────────────────────────────────────────────

    /**
     * Emits a fresh [DashboardStats] whenever any underlying count changes.
     * Uses [combine] so the UI always receives a complete, consistent snapshot.
     */
    fun getDashboardStats(): Flow<DashboardStats> {
        val startOfDay = todayMidnightMillis()
        return combine(
            dao.getTodayBlockedCount(startOfDay),
            dao.getTodayCountByCategory(Category.OTP, startOfDay),
            dao.getTodayCountByCategory(Category.DELIVERY, startOfDay),
            dao.getTodayCountByCategory(Category.PROMOTIONAL, startOfDay),
        ) { blocked, otps, deliveries, promotional ->
            DashboardStats(
                todayBlocked = blocked,
                todayOTPs = otps,
                todayDeliveries = deliveries,
                todayPromotional = promotional,
            )
        }
    }

    fun getTodayBlockedCount(): Flow<Int> =
        dao.getTodayBlockedCount(todayMidnightMillis())

    // ── Helpers ───────────────────────────────────────────────────────────────

    private fun todayMidnightMillis(): Long =
        Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis
}
