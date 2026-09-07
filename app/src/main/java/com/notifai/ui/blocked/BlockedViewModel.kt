package com.notifai.ui.blocked

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notifai.data.model.NotificationEntity
import com.notifai.data.repository.NotificationRepository
import com.notifai.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlockedViewModel @Inject constructor(
    private val repository: NotificationRepository,
) : ViewModel() {

    val blockedNotifications: StateFlow<UiState<List<NotificationEntity>>> =
        repository.getBlockedNotifications()
            .map<List<NotificationEntity>, UiState<List<NotificationEntity>>> {
                UiState.Success(it)
            }
            .catch { emit(UiState.Error("Failed to load blocked notifications", it)) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = UiState.Loading,
            )

    private val _events = kotlinx.coroutines.channels.Channel<String>()
    val events = kotlinx.coroutines.flow.receiveAsFlow(_events)

    fun unblockNotification(id: Long) {
        viewModelScope.launch {
            runCatching { repository.unblockNotification(id) }
                .onFailure { _events.send("Failed to unblock notification") }
        }
    }

    fun deleteNotification(id: Long) {
        viewModelScope.launch {
            runCatching { repository.deleteNotification(id) }
                .onFailure { _events.send("Failed to delete notification") }
        }
    }
}

