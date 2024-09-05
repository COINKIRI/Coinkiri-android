package com.coinkiri.coinkiri.ui.coin.coindetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.coin.usecase.GetCoinDetailInfoUseCase
import com.coinkiri.coinkiri.ui.coin.model.CoinDetailModel
import com.coinkiri.coinkiri.ui.coin.model.PriceModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailInfoUseCase: GetCoinDetailInfoUseCase
) : ViewModel() {

    private val _coinDetailInfo = MutableStateFlow(CoinDetailModel())
    val coinDetailInfo: StateFlow<CoinDetailModel>
        get() = _coinDetailInfo

    suspend fun fetchCoinDetailInfo(marketName: String) {
        viewModelScope.launch {
            val result = getCoinDetailInfoUseCase(marketName)

            result
                .onSuccess { coinDetailInfo ->
                    val coinDetailModel = CoinDetailModel(
                        market = coinDetailInfo.market,
                        price = coinDetailInfo.prices.map { it ->
                            PriceModel(
                                candleDateTimeKst = it.candleDateTimeKst,
                                tradePrice = it.tradePrice
                            )
                        }
                    )
                    _coinDetailInfo.value = coinDetailModel
                }
                .onFailure { exception ->
                    "${exception.message}"
                }
        }
    }
}
