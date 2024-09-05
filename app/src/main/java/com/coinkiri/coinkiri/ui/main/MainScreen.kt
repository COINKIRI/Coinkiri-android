package com.coinkiri.coinkiri.ui.main

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.coinkiri.coinkiri.core.navigation.Route
import com.coinkiri.coinkiri.ui.coin.coinlist.CoinListScreen
import com.coinkiri.coinkiri.ui.coin.coindetail.CoinDetailScreen
import com.coinkiri.coinkiri.ui.coin.navigation.coinGraph
import com.coinkiri.coinkiri.ui.home.navigation.homeNavGraph
import com.coinkiri.coinkiri.ui.login.navigation.loginGraph
import com.coinkiri.coinkiri.ui.profile.ProfileRoute
import com.coinkiri.coinkiri.ui.splash.navigation.splashNavGraph
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
            startDestination = navigator.startDestination,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            }
        ) {
            splashNavGraph(
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
                    navigator.navigateToLogin(navOptions = navOptions)
                }
            )
            loginGraph(
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
            homeNavGraph(
                navigateToProfile = { navigator.navigateProfile() },
                navigateToCoinList = { navigator.navigateCoinList() },
                navigateToTalkList = { navigator.navigateTalk() },
                navigateToBook = {}
            )
            coinGraph(
                navigateToBack = { navigator.popBackStack() },
                navigateToCoinDetail = { marketName ->
                    navigator.navigateToCoinDetail(marketName)
                }
            )
            talkScreen(navigator)
            profileScreen(navigator)
        }
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
