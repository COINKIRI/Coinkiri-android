package com.coinkiri.coinkiri.ui.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.coinkiri.coinkiri.core.navigation.Route
import com.coinkiri.coinkiri.ui.home.HomeScreen

fun NavGraphBuilder.homeNavGraph(
    navigateToProfile: () -> Unit,
    navigateToCoinList: () -> Unit,
    navigateToTalkList: () -> Unit,
    navigateToBook: () -> Unit,
) {
    composable(Route.HomeScreen.routeName) {
        HomeScreen(
            navigateToProfile = navigateToProfile,
            navigateToTalkList = navigateToTalkList,
            navigateToCoinList = navigateToCoinList,
            navigateToBook = navigateToBook
        )
    }
}
