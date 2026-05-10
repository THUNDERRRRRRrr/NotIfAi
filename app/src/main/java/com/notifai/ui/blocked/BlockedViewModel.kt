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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlockedViewModel @Inject constructor(
    private val repository: NotificationRepository,
) : ViewModel() {

    // ── State ─────────────────────────────────────────────────────────────────

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

    // ── Actions ───────────────────────────────────────────────────────────────

    /**
     * Moves a notification from the blocked list back to the allowed feed.
     * The Room Flow will automatically push a fresh list to [blockedNotifications].
     */
    fun unblockNotification(id: Long) {
        viewModelScope.launch {
            runCatching { repository.unblockNotification(id) }
                .onFailure { /* TODO: surface error snackbar via a shared event channel */ }
        }
    }

    /** Permanently removes a notification from the database. */
    fun deleteNotification(id: Long) {
        viewModelScope.launch {
            runCatching { repository.deleteNotification(id) }
                .onFailure { /* TODO: surface error snackbar */ }
        }
    }
}
