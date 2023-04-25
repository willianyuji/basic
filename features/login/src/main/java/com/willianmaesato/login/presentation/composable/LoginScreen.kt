package com.willianmaesato.login.presentation.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.willianmaesato.designsystem.component.textfield.OutlinedTextFieldPassword
import com.willianmaesato.core.extensions.collectAsStateWithLifecycle
import com.willianmaesato.core.extensions.collectWithLifecycle
import com.willianmaesato.features.login.BuildConfig
import com.willianmaesato.features.login.R
import com.willianmaesato.login.presentation.LoginEvent
import com.willianmaesato.login.presentation.LoginUiState
import com.willianmaesato.login.presentation.LoginViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel()
) {

    HandleEvents(viewModel.event)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LoginScreen(
        uiState = uiState,
        onLoginClicked = {

        }
    )
}

@Composable()
internal fun LoginScreen(
    uiState: LoginUiState,
    onLoginClicked: () -> Unit
) {
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) },
        bottomBar = {
            if (!uiState.isLoading) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if(BuildConfig.FLAVOR.contentEquals("paid")){
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp), onClick = { }, shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(text = stringResource(id = R.string.login_button))
                        }
                    }
                }
            }
        }
    ) {
        if (!uiState.isLoading) {
            LoginAvailableContent(
                snackBarHostState = snackBarHostState,
                uiState = uiState,
                onLoginClick = onLoginClicked
            )
        } else {
            LoginNotAvailableContent(
                uiState = uiState
            )
        }
    }
}

@Composable
private fun HandleEvents(events: Flow<LoginEvent>) {
    events.collectWithLifecycle {
        when (it) {
            is LoginEvent.OpenHome -> TODO()
        }
    }
}

@Composable
private fun LoginAvailableContent(
    snackBarHostState: SnackbarHostState,
    uiState: LoginUiState,
    onLoginClick: () -> Unit
) {
    if (uiState.isError) {
        val errorMessage = stringResource(R.string.error_refreshing)

        LaunchedEffect(snackBarHostState) {
            snackBarHostState.showSnackbar(
                message = errorMessage
            )
        }
    }

    Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        com.willianmaesato.designsystem.component.textfield.OutlinedTextFieldText(valueCallBack = {
            print(
                it
            )
        })
        OutlinedTextFieldPassword(valueCallBack = { print(it) })
    }
}

@Composable
private fun LoginNotAvailableContent(uiState: LoginUiState) {
    when {
        uiState.isLoading -> LoginLoadingPlaceholder()
        uiState.isError -> LoginErrorContent()
    }
}
