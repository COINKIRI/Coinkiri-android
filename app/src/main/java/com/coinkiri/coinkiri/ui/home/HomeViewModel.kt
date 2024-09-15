package com.coinkiri.coinkiri.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.coin.usecase.GetCoinRiseAndFallCountUseCase
import com.coinkiri.coinkiri.ui.home.model.CoinCountModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoinRiseAndFallCountUseCase: GetCoinRiseAndFallCountUseCase
) : ViewModel() {

    private val _coinRiseAndFallCount = MutableStateFlow(CoinCountModel())
    val coinRiseAndFallCount: StateFlow<CoinCountModel>
        get() = _coinRiseAndFallCount

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
}
