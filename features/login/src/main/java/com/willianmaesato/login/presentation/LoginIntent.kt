package com.willianmaesato.login.presentation

sealed class LoginIntent {
    object RefreshLogin : LoginIntent()
    object EnterClicked : LoginIntent()
    object BackClicked : LoginIntent()
}