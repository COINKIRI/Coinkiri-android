package com.coinkiri.coinkiri.ui.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.login.entity.request.LoginRequestEntity
import com.coinkiri.coinkiri.domain.login.repository.LoginRepository
import com.coinkiri.coinkiri.domain.token.repository.TokenRepository
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val tokenRepository: TokenRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _loginSideEffects = MutableSharedFlow<LoginSideEffect>()
    val loginSideEffects: SharedFlow<LoginSideEffect>
        get() = _loginSideEffects

    fun startKakaoTalkLogin() {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                handleLoginResult(token, error)
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
                handleLoginResult(token, error)
            }
        }
    }

    private fun handleLoginResult(token: OAuthToken?, error: Throwable?) {
        viewModelScope.launch {
            if (error != null) {
                if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                    handleLoginError("로그인 취소")
                } else {
                    handleLoginError("카카오톡 로그인 실패: ${error.localizedMessage}")
                    startKakaoAccountLogin()
                }
            } else if (token != null) {
                sendTokenToServer(token.accessToken, KAKAO)
            }
        }
    }

    private fun startKakaoAccountLogin() {
        UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
            handleLoginResult(token, error)
        }
    }

    private fun sendTokenToServer(
        accessToken: String,
        platform: String
    ) {
        viewModelScope.launch {
            loginRepository.postLogin(accessToken, LoginRequestEntity(platform))
                .onSuccess { response ->
                    tokenRepository.setTokens(response.accessToken, response.refreshToken)
                    _loginSideEffects.emit(
                        LoginSideEffect.LoginSuccess(
                            response.accessToken
                        )
                    )
                }.onFailure { throwable ->
                    val errorMessage = throwable.localizedMessage ?: "Unknown error"
                    handleLoginError(errorMessage)
                }
        }
    }

    private fun handleLoginError(errorMessage: String) {
        viewModelScope.launch {
            _loginSideEffects.emit(LoginSideEffect.LoginError(errorMessage))
        }
    }

    companion object {
        const val KAKAO = "KAKAO"
        const val NAVER = "NAVER"
    }
}
