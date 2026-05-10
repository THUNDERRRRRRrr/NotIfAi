package com.notifai.ui.common;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.tooling.preview.Preview;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aR\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\b\u0010\u0010\u001a\u00020\u0004H\u0003\u001a\b\u0010\u0011\u001a\u00020\u0004H\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\u00a8\u0006\u0012"}, d2 = {"SavedGreen", "Landroidx/compose/ui/graphics/Color;", "J", "ApiKeyInput", "", "label", "", "value", "onValueChange", "Lkotlin/Function1;", "onSave", "Lkotlin/Function0;", "saveState", "Lcom/notifai/ui/common/UiState;", "modifier", "Landroidx/compose/ui/Modifier;", "ApiKeyInputIdlePreview", "ApiKeyInputSavedPreview", "app_debug"})
public final class ApiKeyInputKt {
    private static final long SavedGreen = 0L;
    
    /**
     * API key input field with show/hide toggle and an inline Save button.
     *
     * [saveState] drives visual feedback:
     * - Loading  → spinner replaces Save button
     * - Success("saved") → green ✓ icon + "Saved!" label for 2 s, then reverts
     * - Error    → red error text below the field
     * - Success("idle")  → normal Save button
     */
    @androidx.compose.runtime.Composable()
    public static final void ApiKeyInput(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSave, @org.jetbrains.annotations.NotNull()
    com.notifai.ui.common.UiState<java.lang.String> saveState, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    private static final void ApiKeyInputSavedPreview() {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    private static final void ApiKeyInputIdlePreview() {
    }
}