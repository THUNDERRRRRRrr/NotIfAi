package com.notifai.ui.blocked;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.tooling.preview.Preview;
import com.notifai.data.model.NotificationEntity;
import com.notifai.ui.common.UiState;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\b\u0010\u0007\u001a\u00020\u0001H\u0003\u001a,\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0003\u00a8\u0006\f"}, d2 = {"BlockedNotificationContent", "", "entity", "Lcom/notifai/data/model/NotificationEntity;", "BlockedScreen", "viewModel", "Lcom/notifai/ui/blocked/BlockedViewModel;", "BlockedScreenPreview", "BlockedSwipeItem", "onUnblock", "Lkotlin/Function0;", "onDelete", "app_debug"})
public final class BlockedScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void BlockedScreen(@org.jetbrains.annotations.NotNull()
    com.notifai.ui.blocked.BlockedViewModel viewModel) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    private static final void BlockedSwipeItem(com.notifai.data.model.NotificationEntity entity, kotlin.jvm.functions.Function0<kotlin.Unit> onUnblock, kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void BlockedNotificationContent(com.notifai.data.model.NotificationEntity entity) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    private static final void BlockedScreenPreview() {
    }
}