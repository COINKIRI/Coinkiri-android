package com.coinkiri.coinkiri.ui.login

sealed class LoginSideEffect {
    data class LoginSuccess(val accessToken: String) : LoginSideEffect()
    data class LoginError(val errorMessage: String) : LoginSideEffect()
}
