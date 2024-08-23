package com.coinkiri.coinkiri.ui.splash

sealed class SplashSideEffect {
    data object NavigateLogin : SplashSideEffect()
    data object NavigateToHome : SplashSideEffect()
}
