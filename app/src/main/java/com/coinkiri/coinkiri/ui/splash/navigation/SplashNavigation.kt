package com.coinkiri.coinkiri.ui.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.coinkiri.coinkiri.core.navigation.Route
import com.coinkiri.coinkiri.ui.splash.SplashScreen

fun NavGraphBuilder.splashNavGraph(
    navigateToHome: (Boolean) -> Unit,
    navigateToLogIn: () -> Unit,
) {
    composable(Route.SplashScreen.routeName) {
        SplashScreen(
            navigateToHome = navigateToHome,
            navigateToLogIn = navigateToLogIn
        )
    }
}
