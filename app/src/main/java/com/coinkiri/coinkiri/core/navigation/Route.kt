package com.coinkiri.coinkiri.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Route(
    val routeName: String
) {
    @Serializable
    data object HomeScreen : Route("home")

    @Serializable
    data object CoinListScreen : Route("coinList")

    @Serializable
    data object TalkScreen : Route("talk")

    @Serializable
    data object ProfileScreen : Route("profile")

    @Serializable
    data object SplashScreen : Route("splash")

    @Serializable
    data object LoginScreen : Route("login")

    @Serializable
    data object CoinDetailScreen : Route("coinDetail/{marketName}") {
        fun createRoute(marketName: String): String = "coinDetail/$marketName"
    }

    @Serializable
    data object TalkDetailScreen : Route("talkDetail")
}
