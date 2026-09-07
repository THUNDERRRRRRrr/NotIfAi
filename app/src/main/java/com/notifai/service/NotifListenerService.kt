package com.notifai.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import android.util.LruCache
import androidx.core.app.NotificationCompat
import com.notifai.MainActivity
import com.notifai.ai.AIProviderManager
import com.notifai.ai.BlockingEngine
import com.notifai.data.model.Category
import com.notifai.data.model.NotificationEntity
import com.notifai.data.repository.NotificationRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.util.concurrent.ConcurrentLinkedQueue
import javax.inject.Inject

@AndroidEntryPoint
class NotifListenerService : NotificationListenerService() {

    @Inject lateinit var repository: NotificationRepository
    @Inject lateinit var aiProviderManager: AIProviderManager
    @Inject lateinit var blockingEngine: BlockingEngine

    private val serviceJob = SupervisorJob()
    private val serviceScope = CoroutineScope(Dispatchers.IO + serviceJob)

    private val pendingQueue = ConcurrentLinkedQueue<RawNotification>()

    private val processedCache = LruCache<String, Boolean>(500)

    private var batchJob: Job? = null

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

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        sbn ?: return

        if (sbn.packageName == packageName) return

        if ((sbn.notification.flags and Notification.FLAG_GROUP_SUMMARY) != 0) return

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
        }.distinctBy { "${it.packageName}|${it.title}|${it.body}" }

        Log.d(TAG, "Processing batch of ${batch.size} notification(s)")

        supervisorScope {
            for (raw in batch) {
                launch {
                    val cacheKey = "${raw.packageName}|${raw.title}|${raw.body}"

                    if (processedCache.get(cacheKey) != null) {
                        return@launch
                    }
                    processedCache.put(cacheKey, true)

                    runCatching {

                        val appMode = getAppMode(raw.packageName)

                        when (appMode) {
                            "ALWAYS_ALLOW" -> {

                                val entity = NotificationEntity(
                                    packageName = raw.packageName,
                                    appName = raw.appName,
                                    title = raw.title,
                                    body = raw.body,
                                    category = Category.IMPORTANT,
                                    confidence = 1.0f,
                                    reason = "Always allowed by user",
                                    timestamp = raw.timestamp,
                                    isBlocked = false,
                                    aiProvider = "user_override",
                                )
                                repository.saveNotification(entity)
                                return@launch
                            }
                            "ALWAYS_BLOCK" -> {

                                val entity = NotificationEntity(
                                    packageName = raw.packageName,
                                    appName = raw.appName,
                                    title = raw.title,
                                    body = raw.body,
                                    category = Category.SPAM,
                                    confidence = 1.0f,
                                    reason = "Always blocked by user",
                                    timestamp = raw.timestamp,
                                    isBlocked = true,
                                    aiProvider = "user_override",
                                )
                                repository.saveNotification(entity)
                                try {
                                    cancelNotification(raw.sbnKey)
                                } catch (_: Exception) { }
                                return@launch
                            }
                            else -> {  }
                        }

                        val response = aiProviderManager.classifyNotification(
                            appName = raw.appName,
                            title = raw.title,
                            body = raw.body,
                        )

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

                        if (entity.isBlocked) {
                            try {
                                cancelNotification(raw.sbnKey)
                                Log.d(TAG, "Blocked & cancelled notification from ${raw.packageName}")
                            } catch (e: Exception) {
                                Log.e(TAG, "Failed to cancel notification ${raw.sbnKey}", e)
                            }
                        }
                    }.onFailure { e ->
                        if (e is CancellationException) throw e
                        Log.e(TAG, "Failed to classify notification from ${raw.packageName}", e)
                    }
                }
            }
        }
    }

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
            .setContentText("Filtering your notifications securely")
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

    private data class RawNotification(
        val packageName: String,
        val appName: String,
        val title: String,
        val body: String,
        val timestamp: Long,
        val sbnKey: String,   
    )

    private fun getAppMode(packageName: String): String {
        val prefs = getSharedPreferences("app_modes", Context.MODE_PRIVATE)
        return prefs.getString(packageName, "AUTO") ?: "AUTO"
    }

    companion object {
        private const val TAG = "NotifListenerService"
        private const val CHANNEL_ID = "notifai_service_channel"
        private const val FOREGROUND_NOTIFICATION_ID = 1001
        private const val BATCH_INTERVAL_MS = 3_000L
    }
}
