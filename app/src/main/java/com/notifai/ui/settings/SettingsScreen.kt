package com.notifai.ui.settings

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.notifai.ui.common.ApiKeyInput
import com.notifai.ui.common.UiState
import com.notifai.ui.theme.DeliveryGreen
import com.notifai.ui.theme.OtpBlue
import com.notifai.ui.theme.PhishingDarkRed
import com.notifai.ui.theme.PromotionalOrange
import com.notifai.ui.theme.SpamRed
import com.notifai.ui.theme.UnknownGray
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val groqKey       by viewModel.groqKey.collectAsStateWithLifecycle()
    val openRouterKey by viewModel.openRouterKey.collectAsStateWithLifecycle()
    val geminiKey     by viewModel.geminiKey.collectAsStateWithLifecycle()
    val sensitivity   by viewModel.sensitivityLevel.collectAsStateWithLifecycle()
    val blockingPrefs by viewModel.blockingPreferences.collectAsStateWithLifecycle()
    val aiModelPrefs  by viewModel.aiModelPreferences.collectAsStateWithLifecycle()

    // Per-key save states
    val groqSaveState       by viewModel.groqSaveState.collectAsStateWithLifecycle()
    val openRouterSaveState by viewModel.openRouterSaveState.collectAsStateWithLifecycle()
    val geminiSaveState     by viewModel.geminiSaveState.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Local editable copies
    var groqInput       by remember(groqKey)       { mutableStateOf(groqKey) }
    var openRouterInput by remember(openRouterKey)  { mutableStateOf(openRouterKey) }
    var geminiInput     by remember(geminiKey)      { mutableStateOf(geminiKey) }

    // Snackbar on error for any field
    LaunchedEffect(groqSaveState, openRouterSaveState, geminiSaveState) {
        listOf(groqSaveState, openRouterSaveState, geminiSaveState)
            .filterIsInstance<UiState.Error>()
            .firstOrNull()
            ?.let { err -> scope.launch { snackbarHostState.showSnackbar(err.message) } }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Settings",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                    )
                },
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
                saveState = groqSaveState,
                modifier = Modifier.fillMaxWidth(),
            )
            ApiKeyInput(
                label = "OpenRouter API Key",
                value = openRouterInput,
                onValueChange = { openRouterInput = it },
                onSave = { viewModel.saveOpenRouterKey(openRouterInput) },
                saveState = openRouterSaveState,
                modifier = Modifier.fillMaxWidth(),
            )
            ApiKeyInput(
                label = "Gemini (Backup)",
                value = geminiInput,
                onValueChange = { geminiInput = it },
                onSave = { viewModel.saveGeminiKey(geminiInput) },
                saveState = geminiSaveState,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))

            // ── Smart AI Cascading ────────────────────────────────────────
            SectionHeader("Smart AI Cascading")

            // Toggle row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Smart Cascading",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        "Auto-switch to better model if confidence is low",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    )
                }
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = aiModelPrefs.enableCascading,
                    onCheckedChange = { viewModel.toggleCascading(it) },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        checkedTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                    ),
                )
            }

            // Cascading options — visible only when cascading is ON
            AnimatedVisibility(
                visible = aiModelPrefs.enableCascading,
                enter = expandVertically(),
                exit = shrinkVertically(),
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Spacer(Modifier.height(4.dp))

                    // Cascade threshold slider
                    val cascadePct = (aiModelPrefs.confidenceThreshold * 100).roundToInt()
                    Text(
                        text = "Cascade if confidence below $cascadePct%",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Slider(
                        value = aiModelPrefs.confidenceThreshold,
                        onValueChange = { viewModel.updateCascadeThreshold(it) },
                        valueRange = 0.5f..1f,
                        steps = 9,  // 0.05 increments → 10 segments → 9 intermediate stops
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.colorScheme.primary,
                            activeTrackColor = MaterialTheme.colorScheme.primary,
                        ),
                        modifier = Modifier.fillMaxWidth(),
                    )

                    Spacer(Modifier.height(4.dp))

                    // Groq model dropdown
                    ModelDropdown(
                        label = "Groq Model",
                        selectedModel = aiModelPrefs.groqModel,
                        options = groqModelOptions,
                        onSelect = { viewModel.setGroqModel(it) },
                    )

                    Spacer(Modifier.height(4.dp))

                    // OpenRouter model dropdown
                    ModelDropdown(
                        label = "OpenRouter Model",
                        selectedModel = aiModelPrefs.openRouterModel,
                        options = openRouterModelOptions,
                        onSelect = { viewModel.setOpenRouterModel(it) },
                    )
                }
            }

            Spacer(Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))

            // ── Blocking Rules ────────────────────────────────────────────
            SectionHeader("What to Block")

            BlockingCategoryRow(
                dotColor = SpamRed,
                name = "Spam",
                description = "Unsolicited junk messages",
                checked = blockingPrefs.blockSpam,
                onCheckedChange = { viewModel.updateBlockingPreference("SPAM", it) },
            )
            BlockingCategoryRow(
                dotColor = PhishingDarkRed,
                name = "Phishing",
                description = "Fake bank alerts and scam links",
                checked = blockingPrefs.blockPhishing,
                onCheckedChange = { viewModel.updateBlockingPreference("PHISHING", it) },
            )
            BlockingCategoryRow(
                dotColor = PromotionalOrange,
                name = "Promotional",
                description = "Marketing and sale notifications",
                checked = blockingPrefs.blockPromotional,
                onCheckedChange = { viewModel.updateBlockingPreference("PROMOTIONAL", it) },
            )
            BlockingCategoryRow(
                dotColor = UnknownGray,
                name = "Unknown",
                description = "Unrecognized notification types",
                checked = blockingPrefs.blockUnknown,
                onCheckedChange = { viewModel.updateBlockingPreference("UNKNOWN", it) },
            )
            BlockingCategoryRow(
                dotColor = DeliveryGreen,
                name = "Delivery",
                description = "Shipping and order updates",
                checked = blockingPrefs.blockDelivery,
                onCheckedChange = { viewModel.updateBlockingPreference("DELIVERY", it) },
            )
            BlockingCategoryRow(
                dotColor = OtpBlue,
                name = "OTP",
                description = "One-time passwords and verification codes",
                checked = blockingPrefs.blockOtp,
                onCheckedChange = { viewModel.updateBlockingPreference("OTP", it) },
            )

            Spacer(Modifier.height(8.dp))

            // ── Blocking Confidence Threshold ─────────────────────────────
            SectionHeader("Confidence Threshold")

            val pct = (blockingPrefs.minConfidenceThreshold * 100).roundToInt()
            Text(
                text = "Block only if AI is $pct% confident",
                style = MaterialTheme.typography.bodyMedium,
            )

            Slider(
                value = blockingPrefs.minConfidenceThreshold,
                onValueChange = { viewModel.updateConfidenceThreshold(it) },
                valueRange = 0f..1f,
                steps = 19,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.primary,
                    activeTrackColor = MaterialTheme.colorScheme.primary,
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Text(
                text = "Higher = fewer false positives, Lower = blocks more",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.55f),
            )

            Spacer(Modifier.height(8.dp))
            HorizontalDivider()
            Spacer(Modifier.height(8.dp))

            // ── Filter Sensitivity ────────────────────────────────────────
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

            Spacer(Modifier.height(32.dp))
        }
    }
}

// ── Reusable Composables ──────────────────────────────────────────────────────

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

@Composable
private fun BlockingCategoryRow(
    dotColor: Color,
    name: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape)
                .background(dotColor),
        )
        Spacer(Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            )
        }
        Spacer(Modifier.width(8.dp))
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.primary,
                checkedTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
            ),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ModelDropdown(
    label: String,
    selectedModel: String,
    options: List<Pair<String, String>>,
    onSelect: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    val displayLabel = options.firstOrNull { it.first == selectedModel }?.second
        ?: selectedModel

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        OutlinedTextField(
            value = displayLabel,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryNotEditable),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { (modelId, displayName) ->
                DropdownMenuItem(
                    text = { Text(displayName) },
                    onClick = {
                        onSelect(modelId)
                        expanded = false
                    },
                )
            }
        }
    }
}

// ── Model option lists ────────────────────────────────────────────────────────

private val groqModelOptions = listOf(
    "llama-3.1-8b-instant"    to "Fast ⚡ (Recommended)",
    "llama-3.3-70b-versatile" to "Accurate \uD83C\uDFAF",
    "llama3-8b-8192"          to "Balanced ⚖\uFE0F",
    "mixtral-8x7b-32768"      to "Alternative \uD83D\uDD04",
)

private val openRouterModelOptions = listOf(
    "meta-llama/llama-3.1-8b-instruct:free"  to "LLaMA 3.1 Free",
    "mistralai/mistral-7b-instruct:free"     to "Mistral 7B Free",
    "google/gemma-2-9b-it:free"              to "Gemma 2 Free",
    "microsoft/phi-3-mini-128k-instruct:free" to "Phi-3 Free",
)
