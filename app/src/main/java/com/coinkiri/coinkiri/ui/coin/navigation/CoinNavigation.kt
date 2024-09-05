package com.coinkiri.coinkiri.ui.coin.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.coinkiri.coinkiri.core.navigation.Route
import com.coinkiri.coinkiri.ui.coin.coindetail.CoinDetailScreen
import com.coinkiri.coinkiri.ui.coin.coinlist.CoinListScreen

fun NavGraphBuilder.coinGraph(
    navigateToBack: () -> Unit,
    navigateToCoinDetail: (String) -> Unit
) {
    composable(Route.CoinListScreen.routeName) {
        CoinListScreen(
            onBackClick = navigateToBack,
            navigateToCoinDetail = navigateToCoinDetail
        )
    }

    composable(
        route = Route.CoinDetailScreen.routeName,
        arguments = listOf(navArgument("marketName") { type = NavType.StringType })
    ) { backStackEntry ->
        val marketName = backStackEntry.arguments?.getString("marketName") ?: ""
        CoinDetailScreen(
            onBackClick = navigateToBack,
            marketName = marketName
        )
    }
}
