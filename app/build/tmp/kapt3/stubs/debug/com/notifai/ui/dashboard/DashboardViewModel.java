package com.notifai.ui.dashboard;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import androidx.lifecycle.ViewModel;
import com.notifai.data.model.DashboardStats;
import com.notifai.data.model.NotificationEntity;
import com.notifai.data.repository.NotificationRepository;
import com.notifai.service.NotifListenerService;
import com.notifai.ui.common.UiState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/notifai/ui/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/notifai/data/repository/NotificationRepository;", "context", "Landroid/content/Context;", "(Lcom/notifai/data/repository/NotificationRepository;Landroid/content/Context;)V", "_isServiceRunning", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "blockedToday", "Lkotlinx/coroutines/flow/StateFlow;", "", "getBlockedToday", "()Lkotlinx/coroutines/flow/StateFlow;", "dashboardStats", "Lcom/notifai/ui/common/UiState;", "Lcom/notifai/data/model/DashboardStats;", "getDashboardStats", "isServiceRunning", "recentNotifications", "", "Lcom/notifai/data/model/NotificationEntity;", "getRecentNotifications", "checkServiceRunning", "refreshServiceStatus", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.data.repository.NotificationRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<com.notifai.data.model.DashboardStats>> dashboardStats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.util.List<com.notifai.data.model.NotificationEntity>>> recentNotifications = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> blockedToday = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isServiceRunning = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isServiceRunning = null;
    
    @javax.inject.Inject()
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.notifai.data.repository.NotificationRepository repository, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<com.notifai.data.model.DashboardStats>> getDashboardStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.util.List<com.notifai.data.model.NotificationEntity>>> getRecentNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getBlockedToday() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isServiceRunning() {
        return null;
    }
    
    /**
     * Re-check whether [NotifListenerService] is active.
     * Call this from the UI when the screen resumes (e.g. returning from
     * the system Notification Access settings screen).
     */
    public final void refreshServiceStatus() {
    }
    
    /**
     * Returns true if the user has granted notification listener access to
     * this app and the [NotifListenerService] component is enabled.
     */
    private final boolean checkServiceRunning() {
        return false;
    }
}