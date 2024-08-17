package com.coinkiri.coinkiri.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coinkiri.coinkiri.ui.home.HomeScreen

@Composable
fun MainScreen() {
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
            homeScreen(navigator)
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

}
