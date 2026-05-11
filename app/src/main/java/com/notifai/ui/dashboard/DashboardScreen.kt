package com.notifai.ui.dashboard

import android.content.Intent
import android.provider.Settings
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.notifai.data.model.DashboardStats
import com.notifai.ui.common.EmptyState
import com.notifai.ui.common.NotificationCard
import com.notifai.ui.common.StatCard
import com.notifai.ui.common.UiState
import com.notifai.ui.navigation.Screen
import com.notifai.ui.theme.DeliveryGreen
import com.notifai.ui.theme.NotifAITheme
import com.notifai.ui.theme.OtpBlue
import com.notifai.ui.theme.PromotionalOrange
import com.notifai.ui.theme.SpamRed
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: DashboardViewModel = hiltViewModel(),
) {
    val statsState by viewModel.dashboardStats.collectAsStateWithLifecycle()
    val recentState by viewModel.recentNotifications.collectAsStateWithLifecycle()
    val isServiceRunning by viewModel.isServiceRunning.collectAsStateWithLifecycle()
    val activeProvider   by viewModel.activeProvider.collectAsStateWithLifecycle()
    val lastConfidence   by viewModel.lastConfidence.collectAsStateWithLifecycle()
    val cascadeCount     by viewModel.cascadeCount.collectAsStateWithLifecycle()
    val lastPingMs       by viewModel.lastPingMs.collectAsStateWithLifecycle()
    val lastError        by viewModel.lastError.collectAsStateWithLifecycle()
    val providerErrors   by viewModel.providerErrors.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) { viewModel.refreshServiceStatus() }

    // Surface errors via Snackbar
    LaunchedEffect(recentState) {
        if (recentState is UiState.Error) {
            snackbarHostState.showSnackbar((recentState as UiState.Error).message)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("NotifAI", style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold)
                },
                actions = {
                    IconButton(onClick = { navController.navigate(Screen.Settings.route) }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = 16.dp),
        ) {
            // ── Service banner ────────────────────────────────────────────
            item {
                AnimatedVisibility(
                    visible = true,
                    enter = expandVertically(),
                    exit = shrinkVertically(),
                ) {
                    ServiceBanner(
                        isActive = isServiceRunning,
                        onClick = {
                            if (!isServiceRunning) {
                                context.startActivity(
                                    Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
                                )
                            }
                        },
                    )
                }
            }

            // ── Today's stats ─────────────────────────────────────────────
            item {
                Text(
                    text = "Today's Summary",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                )
                when (val s = statsState) {
                    is UiState.Loading -> Box(
                        Modifier.fillMaxWidth().height(140.dp),
                        contentAlignment = Alignment.Center,
                    ) { CircularProgressIndicator() }
                    is UiState.Success -> StatsGrid(stats = s.data)
                    is UiState.Error   -> Text(
                        text = s.message,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }

            // ── AI Status Row ─────────────────────────────────────────────
            item {
                AIStatusRow(
                    provider = activeProvider,
                    confidence = lastConfidence,
                    cascades = cascadeCount,
                    pingMs = lastPingMs,
                    errorMessage = lastError,
                    providerErrors = providerErrors,
                )
            }

            // ── Recent header ─────────────────────────────────────────────
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("Recent", style = MaterialTheme.typography.titleLarge)
                    TextButton(onClick = { navController.navigate(Screen.Blocked.route) }) {
                        Text("See all")
                    }
                }
            }

            // ── Notification list ─────────────────────────────────────────
            when (val r = recentState) {
                is UiState.Loading -> item {
                    Box(Modifier.fillMaxWidth().height(200.dp), Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                is UiState.Success -> {
                    if (r.data.isEmpty()) {
                        item {
                            Box(
                                modifier = Modifier.fillMaxWidth().height(220.dp),
                                contentAlignment = Alignment.Center,
                            ) {
                                EmptyState(
                                    icon = Icons.Default.Block,
                                    title = "Nothing yet",
                                    subtitle = "Notifications will appear here",
                                )
                            }
                        }
                    } else {
                        items(r.data, key = { it.id }) { entity ->
                            NotificationCard(entity = entity)
                        }
                    }
                }
                is UiState.Error -> item {
                    Text(r.message, color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Composable
private fun ServiceBanner(isActive: Boolean, onClick: () -> Unit) {
    val bgColor = if (isActive) Color(0xFF1B5E20) else Color(0xFFB71C1C)
    val label   = if (isActive) "● Notification filtering active"
                  else          "● Service inactive — Tap to enable"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
private fun StatsGrid(stats: DashboardStats) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard(
                title = "Blocked",
                count = stats.todayBlocked,
                color = SpamRed,
                icon = Icons.Default.Block,
                modifier = Modifier.weight(1f),
            )
            StatCard(
                title = "OTPs",
                count = stats.todayOTPs,
                color = OtpBlue,
                icon = Icons.Default.Key,
                modifier = Modifier.weight(1f),
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard(
                title = "Deliveries",
                count = stats.todayDeliveries,
                color = DeliveryGreen,
                icon = Icons.Default.LocalShipping,
                modifier = Modifier.weight(1f),
            )
            StatCard(
                title = "Promotional",
                count = stats.todayPromotional,
                color = PromotionalOrange,
                icon = Icons.Default.Campaign,
                modifier = Modifier.weight(1f),
            )
        }
        Spacer(Modifier.height(4.dp))
    }
}
@Composable
private fun AIStatusRow(
    provider: String,
    confidence: Float,
    cascades: Int,
    pingMs: Long,
    errorMessage: String = "",
    providerErrors: Map<String, String> = emptyMap(),
) {
    val chipColor = when (provider.lowercase()) {
        "groq"       -> DeliveryGreen
        "openrouter" -> OtpBlue
        "gemini"     -> PromotionalOrange
        else         -> Color.Gray
    }
    val hasError = errorMessage.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .animateContentSize(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            // Provider chip
            AssistChip(
                onClick = {},
                label = { Text(provider, fontWeight = FontWeight.SemiBold) },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = chipColor.copy(alpha = 0.15f),
                    labelColor = chipColor,
                ),
            )

            // Confidence bar + label
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${(confidence * 100).roundToInt()}% confident",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                )
                Spacer(Modifier.height(4.dp))
                LinearProgressIndicator(
                    progress = { confidence },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = chipColor,
                    trackColor = chipColor.copy(alpha = 0.15f),
                )
            }

            // Metrics (Cascade and Ping)
            Column(horizontalAlignment = Alignment.End) {
                if (pingMs > 0) {
                    Text(
                        text = "⏱\uFE0F ${pingMs}ms",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    )
                }
                if (cascades > 0) {
                    Text(
                        text = "↻ $cascades",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    )
                }
            }
        }

        // ── API Error Banner ──────────────────────────────────────────────
        AnimatedVisibility(
            visible = hasError,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(SpamRed.copy(alpha = 0.1f))
                    .padding(12.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.ErrorOutline,
                        contentDescription = "API Error",
                        tint = SpamRed,
                        modifier = Modifier.size(20.dp),
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "API Error",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = SpamRed,
                    )
                }
                Spacer(Modifier.height(6.dp))
                providerErrors.forEach { (providerName, error) ->
                    val truncated = if (error.length > 150) error.take(150) + "…" else error
                    Text(
                        text = "$providerName: $truncated",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                        modifier = Modifier.padding(top = 2.dp),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardPreview() {
    NotifAITheme {
        DashboardScreen(navController = rememberNavController())
    }
}
