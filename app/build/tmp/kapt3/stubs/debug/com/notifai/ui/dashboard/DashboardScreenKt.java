package com.notifai.ui.dashboard;

import android.content.Intent;
import android.provider.Settings;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.AssistChipDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.navigation.NavController;
import com.notifai.data.model.DashboardStats;
import com.notifai.ui.common.UiState;
import com.notifai.ui.navigation.Screen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aH\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0003\u001a\b\u0010\r\u001a\u00020\u0001H\u0003\u001a\u001a\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u001e\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0003\u00a8\u0006\u001b"}, d2 = {"AIStatusRow", "", "provider", "", "confidence", "", "cascades", "", "pingMs", "", "errorMessage", "providerErrors", "", "DashboardPreview", "DashboardScreen", "navController", "Landroidx/navigation/NavController;", "viewModel", "Lcom/notifai/ui/dashboard/DashboardViewModel;", "ServiceBanner", "isActive", "", "onClick", "Lkotlin/Function0;", "StatsGrid", "stats", "Lcom/notifai/data/model/DashboardStats;", "app_debug"})
public final class DashboardScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void DashboardScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.notifai.ui.dashboard.DashboardViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ServiceBanner(boolean isActive, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StatsGrid(com.notifai.data.model.DashboardStats stats) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AIStatusRow(java.lang.String provider, float confidence, int cascades, long pingMs, java.lang.String errorMessage, java.util.Map<java.lang.String, java.lang.String> providerErrors) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    private static final void DashboardPreview() {
    }
}