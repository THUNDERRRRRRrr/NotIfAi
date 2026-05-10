package com.notifai.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.notifai.ui.common.ApiKeyInput
import com.notifai.ui.common.UiState
import com.notifai.ui.theme.DeliveryGreen
import com.notifai.ui.theme.NotifAITheme
import com.notifai.ui.theme.OtpBlue
import com.notifai.ui.theme.PromotionalOrange
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val groqKey         by viewModel.groqKey.collectAsStateWithLifecycle()
    val openRouterKey   by viewModel.openRouterKey.collectAsStateWithLifecycle()
    val geminiKey       by viewModel.geminiKey.collectAsStateWithLifecycle()
    val activeProvider  by viewModel.activeProvider.collectAsStateWithLifecycle()
    val sensitivity     by viewModel.sensitivityLevel.collectAsStateWithLifecycle()
    val saveState       by viewModel.saveState.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Local editable copies of keys
    var groqInput         by remember(groqKey)        { mutableStateOf(groqKey) }
    var openRouterInput   by remember(openRouterKey)   { mutableStateOf(openRouterKey) }
    var geminiInput       by remember(geminiKey)       { mutableStateOf(geminiKey) }

    // Show snackbar on error
    LaunchedEffect(saveState) {
        if (saveState is UiState.Error) {
            scope.launch { snackbarHostState.showSnackbar((saveState as UiState.Error).message) }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings", style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold) },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            // ── API Keys ──────────────────────────────────────────────────
            SectionHeader("API Keys")

            ApiKeyInput(
                label = "Groq API Key",
                value = groqInput,
                onValueChange = { groqInput = it },
                onSave = { viewModel.saveGroqKey(groqInput) },
                saveState = saveState,
                modifier = Modifier.fillMaxWidth(),
            )
            ApiKeyInput(
                label = "OpenRouter API Key",
                value = openRouterInput,
                onValueChange = { openRouterInput = it },
                onSave = { viewModel.saveOpenRouterKey(openRouterInput) },
                saveState = saveState,
                modifier = Modifier.fillMaxWidth(),
            )
            ApiKeyInput(
                label = "Gemini (Backup)",
                value = geminiInput,
                onValueChange = { geminiInput = it },
                onSave = { viewModel.saveGeminiKey(geminiInput) },
                saveState = saveState,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))

            // ── Active Provider ───────────────────────────────────────────
            SectionHeader("Active Provider")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("Currently using:", style = MaterialTheme.typography.bodyLarge)
                val chipColor = when (activeProvider.lowercase()) {
                    "groq"        -> DeliveryGreen
                    "openrouter"  -> OtpBlue
                    else          -> PromotionalOrange
                }
                AssistChip(
                    onClick = {},
                    label = { Text(activeProvider, fontWeight = FontWeight.SemiBold) },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = chipColor.copy(alpha = 0.12f),
                        labelColor = chipColor,
                    ),
                )
            }

            Spacer(Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))

            // ── Sensitivity ───────────────────────────────────────────────
            SectionHeader("Filter Sensitivity")

            val levels = SensitivityLevel.entries
            SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                levels.forEachIndexed { index, level ->
                    SegmentedButton(
                        selected = sensitivity == level,
                        onClick = { viewModel.setSensitivity(level) },
                        shape = SegmentedButtonDefaults.itemShape(index, levels.size),
                        label = {
                            Text(
                                text = level.name.lowercase()
                                    .replaceFirstChar { it.uppercase() },
                            )
                        },
                    )
                }
            }

            Spacer(Modifier.height(4.dp))
            Text(
                text = when (sensitivity) {
                    SensitivityLevel.AGGRESSIVE -> "Block more, including uncertain cases"
                    SensitivityLevel.BALANCED   -> "Recommended — blocks clear spam only"
                    SensitivityLevel.RELAXED    -> "Only block high confidence spam"
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.65f),
            )
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 4.dp),
    )
}

@Preview(showBackground = true)
@Composable
private fun SettingsScreenPreview() {
    NotifAITheme {
        SettingsScreen()
    }
}
