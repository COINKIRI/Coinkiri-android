package com.coinkiri.coinkiri.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.coin.usecase.GetCoinRiseAndFallCountUseCase
import com.coinkiri.coinkiri.domain.user.entity.UserResponseEntity
import com.coinkiri.coinkiri.domain.user.usecase.GetUserInfoUseCase
import com.coinkiri.coinkiri.ui.home.model.CoinCountModel
import com.coinkiri.coinkiri.ui.profile.model.UserInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoinRiseAndFallCountUseCase: GetCoinRiseAndFallCountUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase
) : ViewModel() {

    private val _coinRiseAndFallCount = MutableStateFlow(CoinCountModel())
    val coinRiseAndFallCount: StateFlow<CoinCountModel>
        get() = _coinRiseAndFallCount

    private val _userInfo = MutableStateFlow(UserInfoModel())
    val userInfo: StateFlow<UserInfoModel>
        get() = _userInfo

    suspend fun fetchCoinRiseAndFallCount() {
        viewModelScope.launch {
            val result = getCoinRiseAndFallCountUseCase()

            result
                .onSuccess { coinCountResponseEntity ->
                    _coinRiseAndFallCount.value = CoinCountModel(
                        riseCount = coinCountResponseEntity.riseCount,
                        fallCount = coinCountResponseEntity.fallCount
                    )
                }
                .onFailure { exception ->
                    "${exception.message}"
                }
        }
    }

    suspend fun fetchUserInfo() =
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
