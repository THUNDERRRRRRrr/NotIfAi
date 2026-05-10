package com.notifai.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.notifai.MainActivity;
import com.notifai.ai.AIProviderManager;
import com.notifai.data.model.Category;
import com.notifai.data.model.NotificationEntity;
import com.notifai.data.repository.NotificationRepository;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.inject.Inject;

/**
 * Core notification-interception service.
 *
 * Lifecycle:
 * - Declared in AndroidManifest with BIND_NOTIFICATION_LISTENER_SERVICE permission.
 * - The user grants access via Settings → Notification Access.
 * - Runs as a foreground service to survive memory pressure.
 * - Batches posted notifications and processes them every [BATCH_INTERVAL_MS].
 * - Calls [AIProviderManager.classifyNotification] for each notification, then
 *   persists the result via [NotificationRepository].
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u001bH\u0082@\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010$\u001a\u00020\u001bH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/notifai/service/NotifListenerService;", "Landroid/service/notification/NotificationListenerService;", "()V", "aiProviderManager", "Lcom/notifai/ai/AIProviderManager;", "getAiProviderManager", "()Lcom/notifai/ai/AIProviderManager;", "setAiProviderManager", "(Lcom/notifai/ai/AIProviderManager;)V", "batchJob", "Lkotlinx/coroutines/Job;", "pendingQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/notifai/service/NotifListenerService$RawNotification;", "repository", "Lcom/notifai/data/repository/NotificationRepository;", "getRepository", "()Lcom/notifai/data/repository/NotificationRepository;", "setRepository", "(Lcom/notifai/data/repository/NotificationRepository;)V", "serviceJob", "Lkotlinx/coroutines/CompletableJob;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "buildForegroundNotification", "Landroid/app/Notification;", "createNotificationChannel", "", "drainQueue", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "onDestroy", "onNotificationPosted", "sbn", "Landroid/service/notification/StatusBarNotification;", "onNotificationRemoved", "startBatchProcessor", "Companion", "RawNotification", "app_debug"})
public final class NotifListenerService extends android.service.notification.NotificationListenerService {
    @javax.inject.Inject()
    public com.notifai.data.repository.NotificationRepository repository;
    @javax.inject.Inject()
    public com.notifai.ai.AIProviderManager aiProviderManager;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CompletableJob serviceJob = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    
    /**
     * Thread-safe queue of raw notifications waiting to be classified.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ConcurrentLinkedQueue<com.notifai.service.NotifListenerService.RawNotification> pendingQueue = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job batchJob;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "NotifListenerService";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String CHANNEL_ID = "notifai_service_channel";
    private static final int FOREGROUND_NOTIFICATION_ID = 1001;
    private static final long BATCH_INTERVAL_MS = 3000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.service.NotifListenerService.Companion Companion = null;
    
    public NotifListenerService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.data.repository.NotificationRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull()
    com.notifai.data.repository.NotificationRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.ai.AIProviderManager getAiProviderManager() {
        return null;
    }
    
    public final void setAiProviderManager(@org.jetbrains.annotations.NotNull()
    com.notifai.ai.AIProviderManager p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onNotificationPosted(@org.jetbrains.annotations.Nullable()
    android.service.notification.StatusBarNotification sbn) {
    }
    
    @java.lang.Override()
    public void onNotificationRemoved(@org.jetbrains.annotations.Nullable()
    android.service.notification.StatusBarNotification sbn) {
    }
    
    private final void startBatchProcessor() {
    }
    
    private final java.lang.Object drainQueue(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final android.app.Notification buildForegroundNotification() {
        return null;
    }
    
    private final void createNotificationChannel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/notifai/service/NotifListenerService$Companion;", "", "()V", "BATCH_INTERVAL_MS", "", "CHANNEL_ID", "", "FOREGROUND_NOTIFICATION_ID", "", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/notifai/service/NotifListenerService$RawNotification;", "", "packageName", "", "appName", "title", "body", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAppName", "()Ljava/lang/String;", "getBody", "getPackageName", "getTimestamp", "()J", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    static final class RawNotification {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String packageName = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String appName = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String title = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String body = null;
        private final long timestamp = 0L;
        
        public RawNotification(@org.jetbrains.annotations.NotNull()
        java.lang.String packageName, @org.jetbrains.annotations.NotNull()
        java.lang.String appName, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String body, long timestamp) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPackageName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAppName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBody() {
            return null;
        }
        
        public final long getTimestamp() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        public final long component5() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.notifai.service.NotifListenerService.RawNotification copy(@org.jetbrains.annotations.NotNull()
        java.lang.String packageName, @org.jetbrains.annotations.NotNull()
        java.lang.String appName, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String body, long timestamp) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}