package com.notifai.ui.dashboard

import android.content.ComponentName
import android.content.Context
import android.provider.Settings
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notifai.ai.AIProviderManager
import com.notifai.data.model.DashboardStats
import com.notifai.data.model.NotificationEntity
import com.notifai.data.repository.NotificationRepository
import com.notifai.service.NotifListenerService
import com.notifai.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: NotificationRepository,
    private val aiProviderManager: AIProviderManager,
    @ApplicationContext private val context: Context,
) : ViewModel() {

    val dashboardStats: StateFlow<UiState<DashboardStats>> =
        repository.getDashboardStats()
            .map<DashboardStats, UiState<DashboardStats>> { UiState.Success(it) }
            .catch { emit(UiState.Error("Failed to load stats", it)) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = UiState.Loading,
            )

    val recentNotifications: StateFlow<UiState<List<NotificationEntity>>> =
        repository.getRecentNotifications(20)
            .map<List<NotificationEntity>, UiState<List<NotificationEntity>>> {
                UiState.Success(it)
            }
            .catch { emit(UiState.Error("Failed to load notifications", it)) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = UiState.Loading,
            )

    val blockedToday: StateFlow<Int> =
        repository.getTodayBlockedCount()
            .catch { emit(0) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = 0,
            )

    val activeProvider: StateFlow<String> = aiProviderManager.activeProvider
    val lastConfidence: StateFlow<Float> = aiProviderManager.lastConfidence
    val cascadeCount: StateFlow<Int> = aiProviderManager.cascadeCount
    val lastPingMs: StateFlow<Long> = aiProviderManager.lastPingMs
    val lastError: StateFlow<String> = aiProviderManager.lastError
    val providerErrors: StateFlow<Map<String, String>> = aiProviderManager.providerErrors

    private val _isServiceRunning = MutableStateFlow(checkServiceRunning())
    val isServiceRunning: StateFlow<Boolean> = _isServiceRunning.asStateFlow()

    fun refreshServiceStatus() {
        _isServiceRunning.value = checkServiceRunning()
    }

    private fun checkServiceRunning(): Boolean {
        val enabledListeners = Settings.Secure.getString(
            context.contentResolver,
            "enabled_notification_listeners",
        ) ?: return false

        val component = ComponentName(context, NotifListenerService::class.java)
        return enabledListeners.contains(component.flattenToString())
    }
}
