package com.notifai.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.notifai.data.model.Category;
import com.notifai.data.model.NotificationEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\'J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u0012\u001a\u00020\u0013H\'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0016\u001a\u00020\u0007H\'J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0007H\'J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u00a7@\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/notifai/data/db/NotificationDao;", "", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNotificationsOlderThan", "timestamp", "getAllNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/notifai/data/model/NotificationEntity;", "getAllowedNotifications", "getBlockedNotifications", "getNotificationsByCategory", "category", "Lcom/notifai/data/model/Category;", "getTodayBlockedCount", "", "startOfDay", "getTodayCountByCategory", "insertNotification", "entity", "(Lcom/notifai/data/model/NotificationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBlockedStatus", "isBlocked", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface NotificationDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNotification(@org.jetbrains.annotations.NotNull()
    com.notifai.data.model.NotificationEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE notifications SET is_blocked = :isBlocked WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateBlockedStatus(long id, boolean isBlocked, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM notifications WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM notifications WHERE timestamp < :timestamp")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNotificationsOlderThan(long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM notifications")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM notifications ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.notifai.data.model.NotificationEntity>> getAllNotifications();
    
    @androidx.room.Query(value = "SELECT * FROM notifications WHERE is_blocked = 1 ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.notifai.data.model.NotificationEntity>> getBlockedNotifications();
    
    @androidx.room.Query(value = "SELECT * FROM notifications WHERE is_blocked = 0 ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.notifai.data.model.NotificationEntity>> getAllowedNotifications();
    
    @androidx.room.Query(value = "SELECT * FROM notifications WHERE category = :category ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.notifai.data.model.NotificationEntity>> getNotificationsByCategory(@org.jetbrains.annotations.NotNull()
    com.notifai.data.model.Category category);
    
    /**
     * [startOfDay] is Unix epoch ms for local midnight, supplied by the
     * repository so this query stays clock-agnostic and easily testable.
     */
    @androidx.room.Query(value = "\n        SELECT COUNT(*) FROM notifications\n        WHERE is_blocked = 1\n          AND timestamp >= :startOfDay\n        ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getTodayBlockedCount(long startOfDay);
    
    @androidx.room.Query(value = "\n        SELECT COUNT(*) FROM notifications\n        WHERE category = :category\n          AND timestamp >= :startOfDay\n        ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getTodayCountByCategory(@org.jetbrains.annotations.NotNull()
    com.notifai.data.model.Category category, long startOfDay);
}