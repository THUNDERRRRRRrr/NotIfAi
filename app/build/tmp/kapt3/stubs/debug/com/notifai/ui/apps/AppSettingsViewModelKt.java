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

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0002"}, d2 = {"PREFS_NAME", "", "app_debug"})
public final class AppSettingsViewModelKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "app_modes";
}