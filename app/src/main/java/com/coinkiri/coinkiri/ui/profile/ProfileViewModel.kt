package com.coinkiri.coinkiri.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.token.usecase.ClearTokenUseCase
import com.coinkiri.coinkiri.domain.user.entity.UserResponseEntity
import com.coinkiri.coinkiri.domain.user.usecase.GetUserInfoUseCase
import com.coinkiri.coinkiri.ui.profile.model.UserInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val clearTokenUseCase: ClearTokenUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
) : ViewModel() {

    private val _profileSideEffects = MutableSharedFlow<ProfileSideEffect>()
    val profileSideEffects: SharedFlow<ProfileSideEffect>
        get() = _profileSideEffects

    private val _userInfo = MutableStateFlow(UserInfoModel())
    val userInfo: StateFlow<UserInfoModel>
        get() = _userInfo

    fun logout() {
        viewModelScope.launch {
            val result = runCatching { clearTokenUseCase }
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

    fun fetchUserInfo() =
        viewModelScope.launch {
            val result = getUserInfoUseCase()

            result
                .onSuccess { userResponseEntity ->
                    handleFetchUserInfoSuccess(userResponseEntity)
                }
                .onFailure { exception ->
                    "${exception.message}"
                }
        }

    private fun handleFetchUserInfoSuccess(userResponseEntity: UserResponseEntity) {
        _userInfo.value = UserInfoModel(
            nickname = userResponseEntity.nickname,
            pic = userResponseEntity.pic
        )
    }
}
