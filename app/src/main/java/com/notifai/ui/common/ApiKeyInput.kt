package com.notifai.ui.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.notifai.ui.theme.NotifAITheme
import kotlinx.coroutines.delay

private val SavedGreen = Color(0xFF2E7D32)

/**
 * API key input field with show/hide toggle and an inline Save button.
 *
 * [saveState] drives visual feedback:
 *  - Loading  → spinner replaces Save button
 *  - Success("saved") → green ✓ icon + "Saved!" label for 2 s, then reverts
 *  - Error    → red error text below the field
 *  - Success("idle")  → normal Save button
 */
@Composable
fun ApiKeyInput(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    onSave: () -> Unit,
    saveState: UiState<String>,
    modifier: Modifier = Modifier,
) {
    var passwordVisible by remember { mutableStateOf(false) }
    // Transient "just saved" flag — auto-clears after 2 s
    var justSaved by remember { mutableStateOf(false) }

    LaunchedEffect(saveState) {
        if (saveState is UiState.Success && saveState.data == "saved") {
            justSaved = true
            delay(2_000)
            justSaved = false
        }
    }

    val isError = saveState is UiState.Error
    val borderColor = when {
        justSaved -> SavedGreen
        isError   -> MaterialTheme.colorScheme.error
        else      -> MaterialTheme.colorScheme.outline
    }

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                label = { Text(label) },
                singleLine = true,
                isError = isError,
                visualTransformation = if (passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.VisibilityOff
                                          else Icons.Default.Visibility,
                            contentDescription = if (passwordVisible) "Hide key" else "Show key",
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor   = borderColor,
                    unfocusedBorderColor = borderColor,
                ),
                modifier = Modifier.weight(1f),
            )
            Spacer(Modifier.width(4.dp))
            when {
                saveState is UiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.size(36.dp))
                }
                justSaved -> {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Saved",
                        tint = SavedGreen,
                        modifier = Modifier.size(36.dp),
                    )
                }
                else -> {
                    FilledTonalButton(onClick = onSave) { Text("Save") }
                }
            }
        }

        // Success "Saved!" label
        AnimatedVisibility(visible = justSaved, enter = fadeIn(), exit = fadeOut()) {
            Spacer(Modifier.height(4.dp))
            Text(
                text = "✓ Saved!",
                style = MaterialTheme.typography.labelSmall,
                color = SavedGreen,
                modifier = Modifier.padding(start = 4.dp),
            )
        }

        // Error label
        if (isError) {
            Spacer(Modifier.height(4.dp))
            Text(
                text = (saveState as UiState.Error).message,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 4.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ApiKeyInputSavedPreview() {
    NotifAITheme {
        ApiKeyInput(
            label = "Groq API Key",
            value = "sk-...9999",
            onValueChange = {},
            onSave = {},
            saveState = UiState.Success("saved"),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ApiKeyInputIdlePreview() {
    NotifAITheme {
        ApiKeyInput(
            label = "Groq API Key",
            value = "",
            onValueChange = {},
            onSave = {},
            saveState = UiState.Success("idle"),
        )
    }
}
