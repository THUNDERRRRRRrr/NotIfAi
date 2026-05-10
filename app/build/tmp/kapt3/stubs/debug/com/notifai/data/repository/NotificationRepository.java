package com.notifai.data.repository;

import com.notifai.data.db.NotificationDao;
import com.notifai.data.model.Category;
import com.notifai.data.model.DashboardStats;
import com.notifai.data.model.NotificationEntity;
import kotlinx.coroutines.flow.Flow;
import java.util.Calendar;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Single source of truth for notification data.
 * ViewModels and Services interact only with this class, never with the DAO directly.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rJ\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0015\u001a\u00020\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\rJ\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\nH\u0002J\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/notifai/data/repository/NotificationRepository;", "", "dao", "Lcom/notifai/data/db/NotificationDao;", "(Lcom/notifai/data/db/NotificationDao;)V", "clearAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNotification", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/notifai/data/model/NotificationEntity;", "getAllowedNotifications", "getBlockedNotifications", "getDashboardStats", "Lcom/notifai/data/model/DashboardStats;", "getNotificationsByCategory", "category", "Lcom/notifai/data/model/Category;", "getTodayBlockedCount", "", "pruneOlderThan", "timestamp", "saveNotification", "entity", "(Lcom/notifai/data/model/NotificationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "todayMidnightMillis", "unblockNotification", "app_debug"})
public final class NotificationRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.data.db.NotificationDao dao = null;
    
    @javax.inject.Inject()
    public NotificationRepository(@org.jetbrains.annotations.NotNull()
    com.notifai.data.db.NotificationDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveNotification(@org.jetbrains.annotations.NotNull()
    com.notifai.data.model.NotificationEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object unblockNotification(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteNotification(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object pruneOlderThan(long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object clearAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.notifai.data.model.NotificationEntity>> getAllNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.notifai.data.model.NotificationEntity>> getBlockedNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.notifai.data.model.NotificationEntity>> getAllowedNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.notifai.data.model.NotificationEntity>> getNotificationsByCategory(@org.jetbrains.annotations.NotNull()
    com.notifai.data.model.Category category) {
        return null;
    }
    
    /**
     * Emits a fresh [DashboardStats] whenever any underlying count changes.
     * Uses [combine] so the UI always receives a complete, consistent snapshot.
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.notifai.data.model.DashboardStats> getDashboardStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getTodayBlockedCount() {
        return null;
    }
    
    private final long todayMidnightMillis() {
        return 0L;
    }
}