package com.notifai.ui.apps;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import androidx.lifecycle.ViewModel;
import com.notifai.data.repository.NotificationRepository;
import com.notifai.ui.common.UiState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bR \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/notifai/ui/apps/AppSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/notifai/data/repository/NotificationRepository;", "context", "Landroid/content/Context;", "(Lcom/notifai/data/repository/NotificationRepository;Landroid/content/Context;)V", "_appList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/notifai/ui/common/UiState;", "", "Lcom/notifai/ui/apps/AppNotificationSetting;", "appList", "Lkotlinx/coroutines/flow/StateFlow;", "getAppList", "()Lkotlinx/coroutines/flow/StateFlow;", "prefs", "Landroid/content/SharedPreferences;", "buildAppList", "countByPackage", "", "", "", "setAppMode", "", "packageName", "mode", "Lcom/notifai/ui/apps/AppMode;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AppSettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.data.repository.NotificationRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.notifai.ui.common.UiState<java.util.List<com.notifai.ui.apps.AppNotificationSetting>>> _appList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.util.List<com.notifai.ui.apps.AppNotificationSetting>>> appList = null;
    
    @javax.inject.Inject()
    public AppSettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.notifai.data.repository.NotificationRepository repository, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.util.List<com.notifai.ui.apps.AppNotificationSetting>>> getAppList() {
        return null;
    }
    
    /**
     * Persists the [mode] override for the given [packageName] and immediately
     * refreshes the [appList] so the UI reflects the change without waiting for
     * a DB event.
     */
    public final void setAppMode(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    com.notifai.ui.apps.AppMode mode) {
    }
    
    private final java.util.List<com.notifai.ui.apps.AppNotificationSetting> buildAppList(java.util.Map<java.lang.String, java.lang.Integer> countByPackage) {
        return null;
    }
}