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
private const val STEP_DONE       = 3   

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _currentStep = MutableStateFlow(STEP_WELCOME)
    val currentStep: StateFlow<Int> = _currentStep.asStateFlow()

    private fun checkPermissionInternal(context: Context): Boolean {
        val enabledListeners = Settings.Secure.getString(
            context.contentResolver,
            "enabled_notification_listeners",
        ) ?: return false

        val component = ComponentName(context, NotifListenerService::class.java)
        return enabledListeners.contains(component.flattenToString())
    }

    private val _isPermissionGranted = MutableStateFlow(checkPermissionInternal(context))
    val isPermissionGranted: StateFlow<Boolean> = _isPermissionGranted.asStateFlow()

    fun nextStep() {
        val next = _currentStep.value + 1
        if (next < STEP_DONE) {
            _currentStep.value = next
        }
    }

    fun checkPermission(context: Context): Boolean {
        val granted = checkPermissionInternal(context)
        _isPermissionGranted.value = granted
        return granted
    }

    fun isOnboardingComplete(): Boolean =
        prefs.getBoolean(KEY_COMPLETE, false)

    fun completeOnboarding() {
        prefs.edit().putBoolean(KEY_COMPLETE, true).apply()
    }
}
