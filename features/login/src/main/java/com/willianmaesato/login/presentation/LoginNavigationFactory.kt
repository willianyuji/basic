package com.willianmaesato.login.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.willianmaesato.core.navigation.NavigationDestination.Login
import com.willianmaesato.core.navigation.NavigationFactory
import com.willianmaesato.login.presentation.composable.LoginRoute
import javax.inject.Inject

class LoginNavigationFactory @Inject constructor() : NavigationFactory {

    override fun create(builder: NavGraphBuilder) {
        builder.composable(Login.route) {
            LoginRoute()
        }
    }
}
