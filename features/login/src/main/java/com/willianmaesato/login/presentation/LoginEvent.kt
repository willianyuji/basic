package com.willianmaesato.login.presentation

sealed class LoginEvent {
    data class OpenHome(val uri: String) : LoginEvent()
}
