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

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\u0015R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/notifai/ui/onboarding/OnboardingViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_currentStep", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isPermissionGranted", "", "currentStep", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentStep", "()Lkotlinx/coroutines/flow/StateFlow;", "isPermissionGranted", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "checkPermission", "checkPermissionInternal", "completeOnboarding", "", "isOnboardingComplete", "nextStep", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OnboardingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isPermissionGranted = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isPermissionGranted = null;
    
    @javax.inject.Inject()
    public OnboardingViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getCurrentStep() {
        return null;
    }
    
    private final boolean checkPermissionInternal(android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isPermissionGranted() {
        return null;
    }
    
    /**
     * Advance to the next onboarding step.
     */
    public final void nextStep() {
    }
    
    /**
     * Checks whether notification listener access has been granted, updates
     * [isPermissionGranted], and returns the result.
     *
     * Call this in `onResume` so the UI reacts when the user returns from the
     * system Notification Access settings screen.
     */
    public final boolean checkPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Returns true if the user has already completed onboarding in a previous
     * session, allowing the app to skip straight to the main UI.
     */
    public final boolean isOnboardingComplete() {
        return false;
    }
    
    /**
     * Marks onboarding as done. Persist before navigating away so the flag
     * survives process death.
     */
    public final void completeOnboarding() {
    }
}