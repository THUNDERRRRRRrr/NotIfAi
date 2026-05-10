package com.notifai.ui.common;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.tooling.preview.Preview;
import com.notifai.data.model.Category;
import com.notifai.data.model.NotificationEntity;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0003\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u00a8\u0006\n"}, d2 = {"NotificationCard", "", "entity", "Lcom/notifai/data/model/NotificationEntity;", "modifier", "Landroidx/compose/ui/Modifier;", "NotificationCardPreview", "toTimeAgo", "", "", "app_debug"})
public final class NotificationCardKt {
    
    /**
     * Converts a timestamp to a human-readable relative string.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toTimeAgo(long $this$toTimeAgo) {
        return null;
    }
    
    /**
     * Single row item representing a [NotificationEntity] in a list.
     * Shows app name, title, category badge, and relative timestamp.
     */
    @androidx.compose.runtime.Composable()
    public static final void NotificationCard(@org.jetbrains.annotations.NotNull()
    com.notifai.data.model.NotificationEntity entity, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    private static final void NotificationCardPreview() {
    }
}