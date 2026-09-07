package com.notifai.ui.common

sealed class UiState<out T> {

    data object Loading : UiState<Nothing>()

    data class Success<out T>(val data: T) : UiState<T>()

    data class Error(
        val message: String,
        val throwable: Throwable? = null,
    ) : UiState<Nothing>()
}

fun <T> UiState<T>.dataOrNull(): T? = (this as? UiState.Success)?.data
