package com.notifai.ui.apps

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notifai.data.repository.NotificationRepository
import com.notifai.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val PREFS_NAME = "app_modes"

@HiltViewModel
class AppSettingsViewModel @Inject constructor(
    private val repository: NotificationRepository,
    @ApplicationContext private val context: Context,
) : ViewModel() {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    // ── State ─────────────────────────────────────────────────────────────────

    private val _appList = MutableStateFlow<UiState<List<AppNotificationSetting>>>(UiState.Loading)
    val appList: StateFlow<UiState<List<AppNotificationSetting>>> = _appList.asStateFlow()

    init {
        // React to DB changes: rebuild app list whenever notification data changes.
        repository.getAllNotifications()
            .map { notifications ->
                // Group notification count by packageName.
                val countByPackage = notifications
                    .groupingBy { it.packageName }
                    .eachCount()

                buildAppList(countByPackage)
            }
            .catch { _appList.value = UiState.Error("Failed to load app list", it) }
            .onEach { _appList.value = UiState.Success(it) }
            .launchIn(viewModelScope)
    }

    // ── Actions ───────────────────────────────────────────────────────────────

    /**
     * Persists the [mode] override for the given [packageName] and immediately
     * refreshes the [appList] so the UI reflects the change without waiting for
     * a DB event.
     */
    fun setAppMode(packageName: String, mode: AppMode) {
        prefs.edit().putString(packageName, mode.name).apply()

        // Patch the current list in-place for instant UI feedback.
        val current = (_appList.value as? UiState.Success)?.data ?: return
        _appList.value = UiState.Success(
            current.map { if (it.packageName == packageName) it.copy(mode = mode) else it }
        )
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private fun buildAppList(countByPackage: Map<String, Int>): List<AppNotificationSetting> {
        val pm = context.packageManager
        return countByPackage.entries
            .sortedByDescending { it.value }
            .mapNotNull { (pkg, count) ->
                runCatching {
                    val info = pm.getApplicationInfo(pkg, PackageManager.GET_META_DATA)
                    AppNotificationSetting(
                        packageName = pkg,
                        appName = pm.getApplicationLabel(info).toString(),
                        appIcon = pm.getApplicationIcon(pkg),
                        mode = AppMode.fromString(prefs.getString(pkg, null)),
                        notificationCount = count,
                    )
                }.getOrNull()   // Skip apps that were uninstalled since last notification
            }
    }
}
