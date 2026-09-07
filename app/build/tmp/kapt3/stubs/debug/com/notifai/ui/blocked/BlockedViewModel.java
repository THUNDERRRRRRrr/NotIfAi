package com.notifai.ui.blocked;

import androidx.lifecycle.ViewModel;
import com.notifai.data.model.NotificationEntity;
import com.notifai.data.repository.NotificationRepository;
import com.notifai.ui.common.UiState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/notifai/ui/blocked/BlockedViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/notifai/data/repository/NotificationRepository;", "(Lcom/notifai/data/repository/NotificationRepository;)V", "_events", "Lkotlinx/coroutines/channels/Channel;", "", "blockedNotifications", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/notifai/ui/common/UiState;", "", "Lcom/notifai/data/model/NotificationEntity;", "getBlockedNotifications", "()Lkotlinx/coroutines/flow/StateFlow;", "events", "error/NonExistentClass", "getEvents", "()Lerror/NonExistentClass;", "Lerror/NonExistentClass;", "deleteNotification", "", "id", "", "unblockNotification", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class BlockedViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.notifai.data.repository.NotificationRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.util.List<com.notifai.data.model.NotificationEntity>>> blockedNotifications = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.channels.Channel<java.lang.String> _events = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object events = null;
    
    @javax.inject.Inject()
    public BlockedViewModel(@org.jetbrains.annotations.NotNull()
    com.notifai.data.repository.NotificationRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.notifai.ui.common.UiState<java.util.List<com.notifai.data.model.NotificationEntity>>> getBlockedNotifications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getEvents() {
        return null;
    }
    
    public final void unblockNotification(long id) {
    }
    
    public final void deleteNotification(long id) {
    }
}