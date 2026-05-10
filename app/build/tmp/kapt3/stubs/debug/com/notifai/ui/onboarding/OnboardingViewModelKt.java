package com.notifai.ui.onboarding;

import android.content.Context;
import android.provider.Settings;
import androidx.lifecycle.ViewModel;
import com.notifai.service.NotifListenerService;
import android.content.ComponentName;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"KEY_COMPLETE", "", "PREFS_NAME", "STEP_DONE", "", "STEP_PERMISSION", "STEP_SETUP", "STEP_WELCOME", "app_debug"})
public final class OnboardingViewModelKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "onboarding";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_COMPLETE = "onboarding_complete";
    private static final int STEP_WELCOME = 0;
    private static final int STEP_PERMISSION = 1;
    private static final int STEP_SETUP = 2;
    private static final int STEP_DONE = 3;
}