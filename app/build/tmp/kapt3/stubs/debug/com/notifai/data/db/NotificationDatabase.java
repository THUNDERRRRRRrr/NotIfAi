package com.notifai.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.notifai.data.model.CategoryConverter;
import com.notifai.data.model.NotificationEntity;

/**
 * Single Room database for the NotifAI app.
 *
 * Hilt provides this singleton via [com.notifai.di.AppModule]; direct
 * access via [NotificationDatabase.getInstance] is available for contexts
 * that cannot use injection (e.g. instrumented tests).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/notifai/data/db/NotificationDatabase;", "Landroidx/room/RoomDatabase;", "()V", "notificationDao", "Lcom/notifai/data/db/NotificationDao;", "app_debug"})
@androidx.room.Database(entities = {com.notifai.data.model.NotificationEntity.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.notifai.data.model.CategoryConverter.class})
public abstract class NotificationDatabase extends androidx.room.RoomDatabase {
    
    public NotificationDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.notifai.data.db.NotificationDao notificationDao();
}