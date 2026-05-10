package com.notifai.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.core.app.NotificationCompat
import com.notifai.MainActivity
import com.notifai.ai.AIProviderManager
import com.notifai.ai.BlockingEngine
import com.notifai.data.model.Category
import com.notifai.data.model.NotificationEntity
import com.notifai.data.repository.NotificationRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentLinkedQueue
import javax.inject.Inject

/**
 * Core notification-interception service.
 *
 * Lifecycle:
 *  - Declared in AndroidManifest with BIND_NOTIFICATION_LISTENER_SERVICE permission.
 *  - The user grants access via Settings → Notification Access.
 *  - Runs as a foreground service to survive memory pressure.
 *  - Batches posted notifications and processes them every [BATCH_INTERVAL_MS].
 *  - Calls [AIProviderManager.classifyNotification] for each notification, then
 *    persists the result via [NotificationRepository].
 */
@AndroidEntryPoint
class NotifListenerService : NotificationListenerService() {

    @Inject lateinit var repository: NotificationRepository
    @Inject lateinit var aiProviderManager: AIProviderManager
    @Inject lateinit var blockingEngine: BlockingEngine

    private val serviceJob = SupervisorJob()
    private val serviceScope = CoroutineScope(Dispatchers.IO + serviceJob)

    /** Thread-safe queue of raw notifications waiting to be classified. */
    private val pendingQueue = ConcurrentLinkedQueue<RawNotification>()

    private var batchJob: Job? = null

    // ── Lifecycle ─────────────────────────────────────────────────────────────

    override fun onCreate() {
        super.onCreate()
        startForeground(FOREGROUND_NOTIFICATION_ID, buildForegroundNotification())
        startBatchProcessor()
        Log.d(TAG, "NotifListenerService created")
    }

    override fun onDestroy() {
        batchJob?.cancel()
        serviceJob.cancel()
        super.onDestroy()
        Log.d(TAG, "NotifListenerService destroyed")
    }

    // ── Notification interception ─────────────────────────────────────────────

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        sbn ?: return

        // Ignore our own notifications (foreground channel, etc.)
        if (sbn.packageName == packageName) return

        // Ignore system notifications that carry no meaningful text
        val extras = sbn.notification?.extras ?: return
        val title = extras.getString(Notification.EXTRA_TITLE).orEmpty()
        val text = (extras.getCharSequence(Notification.EXTRA_TEXT) ?: "").toString()
        if (title.isBlank() && text.isBlank()) return

        val appName = runCatching {
            packageManager.getApplicationLabel(
                packageManager.getApplicationInfo(sbn.packageName, PackageManager.GET_META_DATA)
            ).toString()
        }.getOrDefault(sbn.packageName)

        pendingQueue.offer(
            RawNotification(
                packageName = sbn.packageName,
                appName = appName,
                title = title,
                body = text,
                timestamp = sbn.postTime,
                sbnKey = sbn.key,
            )
        )
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) = Unit

    // ── Batch processor ───────────────────────────────────────────────────────

    private fun startBatchProcessor() {
        batchJob = serviceScope.launch {
            while (isActive) {
                delay(BATCH_INTERVAL_MS)
                drainQueue()
            }
        }
    }

    private suspend fun drainQueue() {
        if (pendingQueue.isEmpty()) return

        val batch = buildList {
            while (pendingQueue.isNotEmpty()) {
                pendingQueue.poll()?.let(::add)
            }
        }

        Log.d(TAG, "Processing batch of ${batch.size} notification(s)")

        for (raw in batch) {
            runCatching {
                val response = aiProviderManager.classifyNotification(
                    appName = raw.appName,
                    title = raw.title,
                    body = raw.body,
                )

                // Use the BlockingEngine (user prefs + confidence) instead of
                // blindly trusting the AI's shouldBlock flag.
                val shouldBlock = blockingEngine.shouldBlock(
                    response.category,
                    response.confidence,
                )

                val entity = NotificationEntity(
                    packageName = raw.packageName,
                    appName = raw.appName,
                    title = raw.title,
                    body = raw.body,
                    category = runCatching {
                        Category.valueOf(response.category.uppercase())
                    }.getOrDefault(Category.UNKNOWN),
                    confidence = response.confidence,
                    reason = response.reason,
                    timestamp = raw.timestamp,
                    isBlocked = shouldBlock,
                    aiProvider = aiProviderManager.activeProvider.value,
                )

                repository.saveNotification(entity)

                // Cancel the notification if AI says it should be blocked
                if (entity.isBlocked) {
                    try {
                        cancelNotification(raw.sbnKey)
                        Log.d(TAG, "Blocked & cancelled notification from ${raw.packageName}")
                    } catch (e: Exception) {
                        Log.e(TAG, "Failed to cancel notification ${raw.sbnKey}", e)
                    }
                }
            }.onFailure { e ->
                Log.e(TAG, "Failed to classify notification from ${raw.packageName}", e)
            }
        }
    }

    // ── Foreground notification ───────────────────────────────────────────────

    private fun buildForegroundNotification(): Notification {
        createNotificationChannel()

        val tapIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE,
        )

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("NotifAI is running")
            .setContentText("Filtering your notifications with AI")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentIntent(tapIntent)
            .setOngoing(true)
            .setSilent(true)
            .build()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "NotifAI Service",
            NotificationManager.IMPORTANCE_MIN,
        ).apply {
            description = "Persistent channel for the NotifAI background service"
            setShowBadge(false)
        }
        getSystemService(NotificationManager::class.java)
            .createNotificationChannel(channel)
    }

    // ── Internal models ───────────────────────────────────────────────────────

    private data class RawNotification(
        val packageName: String,
        val appName: String,
        val title: String,
        val body: String,
        val timestamp: Long,
        val sbnKey: String,   // StatusBarNotification.key — needed to cancel
    )

    companion object {
        private const val TAG = "NotifListenerService"
        private const val CHANNEL_ID = "notifai_service_channel"
        private const val FOREGROUND_NOTIFICATION_ID = 1001
        private const val BATCH_INTERVAL_MS = 3_000L
    }
}
