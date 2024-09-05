package com.coinkiri.coinkiri.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.coinkiri.coinkiri.core.navigation.Route

class ScreenNavigator(
    val navController: NavHostController
) {
    val startDestination = Route.SplashScreen.routeName

    fun navigateToHome(navOptions: NavOptions) =
        navController.navigate(Route.HomeScreen.routeName, navOptions)

    fun navigateToLogin(navOptions: NavOptions? = null) {
        val options = navOptions ?: navOptions {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = false
            }
            launchSingleTop = true
        }
        navController.navigate(Route.LoginScreen.routeName, options)
    }

    fun navigateCoinList() {
        navController.navigate(Route.CoinListScreen.routeName)
    }

    fun navigateToCoinDetail() =
        navController.navigate(Route.CoinDetailScreen.routeName)

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
