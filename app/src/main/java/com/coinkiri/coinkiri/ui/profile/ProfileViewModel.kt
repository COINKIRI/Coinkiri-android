package com.coinkiri.coinkiri.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.token.repository.TokenRepository
import com.coinkiri.coinkiri.ui.login.LoginSideEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val tokenRepository: TokenRepository
) : ViewModel() {

    private val _profileSideEffects = MutableSharedFlow<ProfileSideEffect>()
    val profileSideEffects: SharedFlow<ProfileSideEffect>
        get() = _profileSideEffects

    fun logout() {
        viewModelScope.launch {
            val result = runCatching { tokenRepository.clearInfo() }
            result
                .onSuccess { handleLogoutSuccess() }
                .onFailure { handleLogoutFailure(it) }
        }
    }

    private suspend fun handleLogoutSuccess() {
        _profileSideEffects.emit(
            ProfileSideEffect.LogoutSuccess(
                successMessage = "로그아웃 성공"
            )
        )
    }

    private suspend fun handleLogoutFailure(exception: Throwable) {
        _profileSideEffects.emit(
            ProfileSideEffect.LogoutFailure(
                errorMessage = "로그아웃 실패: ${exception.message}"
            )
        )
    }
}
