package com.willianmaesato.login.presentation

import androidx.lifecycle.SavedStateHandle
import com.willianmaesato.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.willianmaesato.login.presentation.LoginUiState.PartialState
import com.willianmaesato.login.presentation.LoginUiState.PartialState.Error
import com.willianmaesato.login.presentation.LoginUiState.PartialState.Fetched
import com.willianmaesato.login.presentation.LoginUiState.PartialState.Loading
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
//    private val getRocketsUseCase: GetRocketsUseCase,
//    private val refreshRocketsUseCase: RefreshRocketsUseCase,
    savedStateHandle: SavedStateHandle,
    loginInitialState: LoginUiState
) : BaseViewModel<LoginUiState, PartialState, LoginEvent, LoginIntent>(
    savedStateHandle,
    loginInitialState
) {

    init {
        getLogin()
    }

    override fun mapIntents(intent: LoginIntent): Flow<PartialState> = when (intent) {
        is LoginIntent.BackClicked -> TODO()
        is LoginIntent.EnterClicked -> refreshLogin()
        is LoginIntent.RefreshLogin -> TODO()
    }

    override fun reduceUiState(
        previousState: LoginUiState,
        partialState: PartialState
    ): LoginUiState = when (partialState) {
        is Loading -> previousState.copy(
            isLoading = true,
            isError = false
        )
        is Fetched -> previousState.copy(
            isLoading = false,
            isError = false
        )
        is Error -> previousState.copy(
            isLoading = false,
            isError = true
        )
    }

    private fun getLogin(): Flow<PartialState> = flow {
        emptyFlow<PartialState>()
    }

    private fun refreshLogin(): Flow<PartialState> = flow {
        emptyFlow<PartialState>()
    }
}
