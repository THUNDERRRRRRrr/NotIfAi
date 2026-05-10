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
 *
 * All ViewModels and Services interact with this class, never with the DAO
 * directly. This keeps the database implementation detail hidden and makes
 * the layer easy to swap or mock in tests.
 */
@Singleton
class NotificationRepository @Inject constructor(
    private val dao: NotificationDao,
) {

    // ── Writes ────────────────────────────────────────────────────────────────

    /**
     * Persists a classified [NotificationEntity] to the database.
     * Must be called from a coroutine / suspend context.
     */
    suspend fun saveNotification(entity: NotificationEntity) =
        dao.insertNotification(entity)

    /** Removes all notifications older than [timestamp] (Unix epoch ms). */
    suspend fun pruneOlderThan(timestamp: Long) =
        dao.deleteNotificationsOlderThan(timestamp)

    /** Wipes the entire notification history. */
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
     * Emits a fresh [DashboardStats] whenever any of the underlying counts
     * changes.  Uses [combine] so the downstream collector always sees a
     * consistent snapshot — no partial updates.
     *
     * "Today" resets at local midnight on each subscription; for long-lived
     * collectors (e.g. a ViewModel that survives past midnight) the stats
     * will be slightly stale until the app is restarted.  A production
     * implementation should post a midnight-reset work request via
     * WorkManager.
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

    // ── Helpers ───────────────────────────────────────────────────────────────

    /** Returns Unix epoch ms for midnight (00:00:00.000) of the current day. */
    private fun todayMidnightMillis(): Long =
        Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis
}
