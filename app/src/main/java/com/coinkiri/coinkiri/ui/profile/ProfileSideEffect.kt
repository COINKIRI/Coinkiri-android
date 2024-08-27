package com.coinkiri.coinkiri.ui.profile

sealed class ProfileSideEffect {
    data class LogoutSuccess(val successMessage: String) : ProfileSideEffect()
    data class LogoutFailure(val errorMessage: String) : ProfileSideEffect()
}
