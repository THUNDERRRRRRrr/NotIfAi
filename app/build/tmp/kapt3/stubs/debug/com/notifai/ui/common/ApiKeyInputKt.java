package com.notifai.ui.common;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.tooling.preview.Preview;
import com.notifai.ui.common.UiState;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aR\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001a\b\u0010\r\u001a\u00020\u0001H\u0003\u00a8\u0006\u000e"}, d2 = {"ApiKeyInput", "", "label", "", "value", "onValueChange", "Lkotlin/Function1;", "onSave", "Lkotlin/Function0;", "saveState", "Lcom/notifai/ui/common/UiState;", "modifier", "Landroidx/compose/ui/Modifier;", "ApiKeyInputPreview", "app_debug"})
public final class ApiKeyInputKt {
    
    /**
     * API key input field with show/hide toggle and an inline Save button.
     * Reflects [saveState] with a spinner (Loading) or error text (Error).
     */
    @androidx.compose.runtime.Composable()
    public static final void ApiKeyInput(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSave, @org.jetbrains.annotations.NotNull()
    com.notifai.ui.common.UiState<kotlin.Unit> saveState, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    private static final void ApiKeyInputPreview() {
    }
}