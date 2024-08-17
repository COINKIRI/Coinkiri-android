package com.coinkiri.coinkiri.ui.main

sealed class Route(
    val routeName: String
) {
    data object HomeScreen : Route("home")
    data object CoinScreen : Route("coin")
    data object TalkScreen : Route("talk")
    data object ProfileScreen : Route("profile")

    data object SplashScreen : Route("splash")
    data object LoginScreen : Route("login")

    data object CoinDetailScreen : Route("coinDetail")
    data object TalkDetailScreen : Route("talkDetail")
}
