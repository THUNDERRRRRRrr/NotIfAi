package com.notifai.ui.onboarding

import android.content.Context
import android.provider.Settings
import androidx.lifecycle.ViewModel
import com.notifai.service.NotifListenerService
import android.content.ComponentName
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

private const val PREFS_NAME = "onboarding"
private const val KEY_COMPLETE = "onboarding_complete"

private const val STEP_WELCOME    = 0
private const val STEP_PERMISSION = 1
private const val STEP_SETUP      = 2
private const val STEP_DONE       = 3   // sentinel — onboarding complete

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    // ── State ─────────────────────────────────────────────────────────────────

    private val _currentStep = MutableStateFlow(STEP_WELCOME)
    val currentStep: StateFlow<Int> = _currentStep.asStateFlow()

    private val _isPermissionGranted = MutableStateFlow(checkPermission(context))
    val isPermissionGranted: StateFlow<Boolean> = _isPermissionGranted.asStateFlow()

    // ── Actions ───────────────────────────────────────────────────────────────

    /** Advance to the next onboarding step. */
    fun nextStep() {
        val next = _currentStep.value + 1
        if (next < STEP_DONE) {
            _currentStep.value = next
        }
    }

    /**
     * Checks whether notification listener access has been granted, updates
     * [isPermissionGranted], and returns the result.
     *
     * Call this in `onResume` so the UI reacts when the user returns from the
     * system Notification Access settings screen.
     */
    fun checkPermission(context: Context): Boolean {
        val enabledListeners = Settings.Secure.getString(
            context.contentResolver,
            "enabled_notification_listeners",
        ) ?: return false

        val component = ComponentName(context, NotifListenerService::class.java)
        val granted = enabledListeners.contains(component.flattenToString())
        _isPermissionGranted.value = granted
        return granted
    }

    /**
     * Returns true if the user has already completed onboarding in a previous
     * session, allowing the app to skip straight to the main UI.
     */
    fun isOnboardingComplete(): Boolean =
        prefs.getBoolean(KEY_COMPLETE, false)

    /**
     * Marks onboarding as done. Persist before navigating away so the flag
     * survives process death.
     */
    fun completeOnboarding() {
        prefs.edit().putBoolean(KEY_COMPLETE, true).apply()
    }
}
