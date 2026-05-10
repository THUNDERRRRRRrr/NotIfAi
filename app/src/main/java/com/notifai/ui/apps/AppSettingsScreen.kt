package com.notifai.ui.apps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.notifai.ui.common.EmptyState
import com.notifai.ui.common.UiState
import com.notifai.ui.theme.DeliveryGreen
import com.notifai.ui.theme.NotifAITheme
import com.notifai.ui.theme.SpamRed
import com.notifai.ui.theme.UnknownGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSettingsScreen(
    viewModel: AppSettingsViewModel = hiltViewModel(),
) {
    val state by viewModel.appList.collectAsStateWithLifecycle()
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("App Settings", style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold) },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            // Search bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search apps…") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            )

            when (val s = state) {
                is UiState.Loading -> Box(Modifier.fillMaxSize(), Alignment.Center) {
                    CircularProgressIndicator()
                }
                is UiState.Error -> Text(
                    text = s.message,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp),
                )
                is UiState.Success -> {
                    val filtered = s.data.filter {
                        searchQuery.isBlank() ||
                            it.appName.contains(searchQuery, ignoreCase = true)
                    }

                    if (filtered.isEmpty()) {
                        EmptyState(
                            icon = Icons.Default.Apps,
                            title = "No apps found",
                            subtitle = "Apps will appear after first notifications",
                            modifier = Modifier.fillMaxSize().padding(32.dp),
                        )
                    } else {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(filtered, key = { it.packageName }) { app ->
                                AppSettingRow(
                                    app = app,
                                    onModeChange = { mode ->
                                        viewModel.setAppMode(app.packageName, mode)
                                    },
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppSettingRow(
    app: AppNotificationSetting,
    onModeChange: (AppMode) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // App icon + name
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f),
            ) {
                if (app.appIcon != null) {
                    Image(
                        painter = rememberDrawablePainter(app.appIcon),
                        contentDescription = app.appName,
                        modifier = Modifier.size(40.dp).clip(CircleShape),
                    )
                } else {
                    Box(
                        modifier = Modifier.size(40.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(Icons.Default.Apps, contentDescription = null,
                            modifier = Modifier.size(24.dp))
                    }
                }

                Spacer(Modifier.width(12.dp))

                Column {
                    Text(app.appName, style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold)
                    SuggestionChip(
                        onClick = {},
                        label = { Text("${app.notificationCount} notifications",
                            style = MaterialTheme.typography.labelSmall) },
                        modifier = Modifier.padding(top = 2.dp),
                    )
                }
            }

            Spacer(Modifier.width(8.dp))

            // Mode dropdown
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it },
            ) {
                val modeColor = when (app.mode) {
                    AppMode.AUTO         -> UnknownGray
                    AppMode.ALWAYS_ALLOW -> DeliveryGreen
                    AppMode.ALWAYS_BLOCK -> SpamRed
                }
                SuggestionChip(
                    onClick = { expanded = true },
                    label = {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Box(
                                modifier = Modifier.size(8.dp).clip(CircleShape)
                                    .background(modeColor),
                            )
                            Text(app.mode.name.replace("_", " "),
                                style = MaterialTheme.typography.labelSmall)
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                        }
                    },
                    colors = SuggestionChipDefaults.suggestionChipColors(
                        containerColor = modeColor.copy(alpha = 0.10f),
                    ),
                    modifier = Modifier.menuAnchor(),
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    AppMode.entries.forEach { mode ->
                        DropdownMenuItem(
                            text = { Text(mode.name.replace("_", " ")) },
                            onClick = {
                                onModeChange(mode)
                                expanded = false
                            },
                        )
                    }
                }
            }
        }
        HorizontalDivider(thickness = 0.5.dp,
            color = MaterialTheme.colorScheme.outlineVariant,
            modifier = Modifier.padding(horizontal = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun AppSettingsPreview() {
    NotifAITheme {
        AppSettingsScreen()
    }
}
