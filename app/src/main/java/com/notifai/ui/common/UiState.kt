package com.notifai.ui.common

/**
 * Generic UI state wrapper used across all screens.
 *
 * Usage in a ViewModel:
 * ```kotlin
 * private val _uiState = MutableStateFlow<UiState<MyData>>(UiState.Loading)
 * val uiState: StateFlow<UiState<MyData>> = _uiState.asStateFlow()
 * ```
 */
sealed class UiState<out T> {
    /** Initial / in-flight state. Show a loading indicator. */
    data object Loading : UiState<Nothing>()

    /** Data is available and ready to display. */
    data class Success<out T>(val data: T) : UiState<T>()

    /** An error occurred. [message] is user-facing; [throwable] for logging. */
    data class Error(
        val message: String,
        val throwable: Throwable? = null,
    ) : UiState<Nothing>()
}

/** Returns the wrapped data or null if this is not a [UiState.Success]. */
fun <T> UiState<T>.dataOrNull(): T? = (this as? UiState.Success)?.data
