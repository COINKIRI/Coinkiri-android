package com.coinkiri.coinkiri.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.coinkiri.coinkiri.ui.coin.CoinScreen
import com.coinkiri.coinkiri.ui.home.HomeScreen
import com.coinkiri.coinkiri.ui.login.LoginRoute
import com.coinkiri.coinkiri.ui.profile.ProfileRoute
import com.coinkiri.coinkiri.ui.splash.SplashScreen
import com.coinkiri.coinkiri.ui.talk.TalkScreen

@Composable
fun MainScreen(
    navigator: ScreenNavigator = rememberScreenNavigator()
) {
    MainScreenContent(
        navigator = navigator
    )
}

@Composable
private fun MainScreenContent(
    navigator: ScreenNavigator
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination
        ) {
            splashScreen(navigator)
            homeScreen(navigator)
            coinScreen(navigator)
            talkScreen(navigator)
            profileScreen(navigator)
            loginRoute(navigator)
        }
    }
}

private fun NavGraphBuilder.splashScreen(navigator: ScreenNavigator) {
    composable(Route.SplashScreen.routeName) {
        SplashScreen(
            navigateToHome = {
                val navOptions = navOptions {
                    popUpTo(navigator.navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
                navigator.navigateToHome(navOptions = navOptions)
            },
            navigateToLogIn = {
                val navOptions = navOptions {
                    popUpTo(navigator.navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
                navigator.navigateToLogin(
                    navOptions = navOptions
                )
            }
        )
    }
}

private fun NavGraphBuilder.homeScreen(navigator: ScreenNavigator) {
    composable(Route.HomeScreen.routeName) {
        HomeScreen(
            onProfileClick = { navigator.navigateProfile() },
            onTalkClick = { navigator.navigateTalk() },
            onPriceClick = { navigator.navigateCoin() },
            onBookClick = { }
        )
    }
}

private fun NavGraphBuilder.loginRoute(navigator: ScreenNavigator) {
    composable(Route.LoginScreen.routeName) {
        LoginRoute(
            navigateToHome = {
                val navOptions = navOptions {
                    popUpTo(navigator.navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
                navigator.navigateToHome(navOptions = navOptions)
            }
        )
    }
}

private fun NavGraphBuilder.coinScreen(navigator: ScreenNavigator) {
    composable(Route.CoinScreen.routeName) {
        CoinScreen(
            onBackClick = { navigator.popBackStack() }
        )
    }
}

private fun NavGraphBuilder.talkScreen(navigator: ScreenNavigator) {
    composable(Route.TalkScreen.routeName) {
        TalkScreen(
            onBackClick = { navigator.popBackStack() }
        )
    }
}

private fun NavGraphBuilder.profileScreen(navigator: ScreenNavigator) {
    composable(Route.ProfileScreen.routeName) {
        ProfileRoute(
            onBackClick = { navigator.popBackStack() },
            navigateToLogin = { navigator.navigateToLogin() }
        )
    }
}
