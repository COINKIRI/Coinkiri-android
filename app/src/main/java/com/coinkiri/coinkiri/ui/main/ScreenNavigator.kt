package com.coinkiri.coinkiri.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions

class ScreenNavigator(
    val navController: NavHostController
) {
    val startDestination = Route.SplashScreen.routeName

    fun navigateHome() {
        navController.navigate(Route.HomeScreen.routeName)
    fun navigateToHome(navOptions: NavOptions) =
        navController.navigate(Route.HomeScreen.routeName, navOptions)

    }

    fun navigateCoin() {
        navController.navigate(Route.CoinScreen.routeName)
    }

    fun navigateTalk() {
        navController.navigate(Route.TalkScreen.routeName)
    }

    fun navigateProfile() {
        navController.navigate(Route.ProfileScreen.routeName)
    }

    fun popBackStack() {
        navController.popBackStack()
    }
}

@Composable
fun rememberScreenNavigator(
    navController: NavHostController = rememberNavController(),
): ScreenNavigator = remember(navController) {
    ScreenNavigator(navController)
}
