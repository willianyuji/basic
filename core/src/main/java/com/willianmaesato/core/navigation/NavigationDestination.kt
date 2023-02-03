package com.willianmaesato.core.navigation

sealed class NavigationDestination(
    val route: String
) {
    object Login : NavigationDestination("loginDestination")
    object Back : NavigationDestination("navigationBack")
}
