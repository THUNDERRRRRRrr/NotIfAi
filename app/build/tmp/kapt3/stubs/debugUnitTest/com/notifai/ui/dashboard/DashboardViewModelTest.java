package com.notifai.ui.dashboard;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.notifai.data.model.DashboardStats;
import com.notifai.data.model.NotificationEntity;
import com.notifai.data.repository.NotificationRepository;
import com.notifai.service.NotifListenerService;
import com.notifai.ui.common.UiState;
import com.notifai.util.MainDispatcherRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0007J\f\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0007J\f\u0010\u0013\u001a\u00060\u0010j\u0002`\u0011H\u0007J\f\u0010\u0014\u001a\u00060\u0010j\u0002`\u0011H\u0007J\f\u0010\u0015\u001a\u00060\u0010j\u0002`\u0011H\u0007J\f\u0010\u0016\u001a\u00060\u0010j\u0002`\u0011H\u0007J\f\u0010\u0017\u001a\u00060\u0010j\u0002`\u0011H\u0007J\b\u0010\u0018\u001a\u00020\u0010H\u0007J\b\u0010\u0019\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/notifai/ui/dashboard/DashboardViewModelTest;", "", "()V", "contentResolver", "Landroid/content/ContentResolver;", "context", "Landroid/content/Context;", "mainDispatcherRule", "Lcom/notifai/util/MainDispatcherRule;", "getMainDispatcherRule", "()Lcom/notifai/util/MainDispatcherRule;", "repository", "Lcom/notifai/data/repository/NotificationRepository;", "viewModel", "Lcom/notifai/ui/dashboard/DashboardViewModel;", "blockedToday returns value from repository", "", "Lkotlinx/coroutines/test/TestResult;", "checkServiceRunning returns false when component is not in enabled_notification_listeners", "checkServiceRunning returns true when component is in enabled_notification_listeners", "dashboardStats handles errors by emitting Error state", "dashboardStats initially emits Loading, then Success", "recentNotifications limits to 20 items", "refreshServiceStatus updates isServiceRunning value", "setup", "tearDown", "app_debugUnitTest"})
public final class DashboardViewModelTest {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.util.MainDispatcherRule mainDispatcherRule = null;
    private com.notifai.ui.dashboard.DashboardViewModel viewModel;
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.data.repository.NotificationRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.ContentResolver contentResolver = null;
    
    public DashboardViewModelTest() {
        super();
    }
    
    @org.junit.Rule()
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.util.MainDispatcherRule getMainDispatcherRule() {
        return null;
    }
    
    @org.junit.Before()
    public final void setup() {
    }
    
    @org.junit.After()
    public final void tearDown() {
    }
}