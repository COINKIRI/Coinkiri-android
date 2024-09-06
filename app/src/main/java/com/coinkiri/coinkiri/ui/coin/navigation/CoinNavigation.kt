package com.coinkiri.coinkiri.ui.coin.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.coinkiri.coinkiri.core.navigation.Route
import com.coinkiri.coinkiri.ui.coin.coindetail.CoinDetailScreen
import com.coinkiri.coinkiri.ui.coin.coinlist.CoinListScreen
import com.coinkiri.coinkiri.ui.coin.model.CoinModel

fun NavGraphBuilder.coinGraph(
    navigateToBack: () -> Unit,
    navigateToCoinDetail: (CoinModel) -> Unit
) {
    composable(Route.CoinListScreen.routeName) {
        CoinListScreen(
            onBackClick = navigateToBack,
            navigateToCoinDetail = navigateToCoinDetail
        )
    }

    composable(
        route = Route.CoinDetailScreen.routeName,
        arguments = listOf(
            navArgument("marketName") { type = NavType.StringType },
            navArgument("koreanName") { type = NavType.StringType },
            navArgument("symbol") { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val coinModel = CoinModel(
            marketName = backStackEntry.arguments?.getString("marketName") ?: "",
            koreanName = backStackEntry.arguments?.getString("koreanName") ?: "",
            symbol = backStackEntry.arguments?.getString("symbol") ?: ""
        )

        CoinDetailScreen(
            onBackClick = navigateToBack,
            coinModel = coinModel
        )
    }
}
