package com.coinkiri.coinkiri.ui.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.coinkiri.coinkiri.core.navigation.Route
import com.coinkiri.coinkiri.ui.login.LoginRoute

fun NavGraphBuilder.loginGraph(
    navigateToHome: () -> Unit
) {
    composable(Route.LoginScreen.routeName) {
        LoginRoute(
            navigateToHome = navigateToHome
        )
    }
}
