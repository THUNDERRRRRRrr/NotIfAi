package com.notifai.ui.blocked;

import androidx.lifecycle.ViewModel;
import com.notifai.data.model.NotificationEntity;
import com.notifai.data.repository.NotificationRepository;
import com.notifai.ui.common.UiState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/notifai/ui/blocked/BlockedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/notifai/data/repository/NotificationRepository;", "(Lcom/notifai/data/repository/NotificationRepository;)V", "blockedNotifications", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/notifai/ui/common/UiState;", "", "Lcom/notifai/data/model/NotificationEntity;", "getBlockedNotifications", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteNotification", "", "id", "", "unblockNotification", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class BlockedViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.data.repository.NotificationRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.util.List<com.notifai.data.model.NotificationEntity>>> blockedNotifications = null;
    
    @javax.inject.Inject()
    public BlockedViewModel(@org.jetbrains.annotations.NotNull()
    com.notifai.data.repository.NotificationRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.util.List<com.notifai.data.model.NotificationEntity>>> getBlockedNotifications() {
        return null;
    }
    
    /**
     * Moves a notification from the blocked list back to the allowed feed.
     * The Room Flow will automatically push a fresh list to [blockedNotifications].
     */
    public final void unblockNotification(long id) {
    }
    
    /**
     * Permanently removes a notification from the database.
     */
    public final void deleteNotification(long id) {
    }
}