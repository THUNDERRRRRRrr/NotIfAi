package com.notifai.data.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
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
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/notifai/data/db/NotificationDatabase;", "Landroidx/room/RoomDatabase;", "()V", "notificationDao", "Lcom/notifai/data/db/NotificationDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.notifai.data.model.NotificationEntity.class}, version = 1, exportSchema = true)
@androidx.room.TypeConverters(value = {com.notifai.data.model.CategoryConverter.class})
public abstract class NotificationDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DB_NAME = "notifai.db";
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.notifai.data.db.NotificationDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.data.db.NotificationDatabase.Companion Companion = null;
    
    public NotificationDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.notifai.data.db.NotificationDao notificationDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/notifai/data/db/NotificationDatabase$Companion;", "", "()V", "DB_NAME", "", "INSTANCE", "Lcom/notifai/data/db/NotificationDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.notifai.data.db.NotificationDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}