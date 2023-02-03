package com.willianmaesato.login.presentation

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class LoginUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false
) : Parcelable {

    sealed class PartialState {
        object Loading : PartialState() // for simplicity: initial loading & refreshing

        object Fetched : PartialState()

        data class Error(val throwable: Throwable) : PartialState()
    }
}
