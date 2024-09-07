package com.coinkiri.coinkiri.ui.coin.coindetail

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.core.designsystem.theme.Blue
import com.coinkiri.coinkiri.core.designsystem.theme.Red
import com.coinkiri.coinkiri.domain.coin.usecase.GetCoinDetailInfoUseCase
import com.coinkiri.coinkiri.domain.ticker.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.ticker.entity.response.TickerDetailResponseEntity
import com.coinkiri.coinkiri.domain.ticker.usecase.GetTickerDetailUseCase
import com.coinkiri.coinkiri.ui.coin.model.CoinDetailModel
import com.coinkiri.coinkiri.ui.coin.model.PriceModel
import com.coinkiri.coinkiri.ui.coin.model.TickerDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailInfoUseCase: GetCoinDetailInfoUseCase,
    private val getTickerDetailUseCase: GetTickerDetailUseCase
) : ViewModel() {

    private val _coinDetailInfo = MutableStateFlow(CoinDetailModel())
    val coinDetailInfo: StateFlow<CoinDetailModel>
        get() = _coinDetailInfo

    private val _tickerDetailInfo = MutableStateFlow(TickerDetailModel())
    val tickerDetailModel: StateFlow<TickerDetailModel>
        get() = _tickerDetailInfo

    private val _changeRateColor = MutableStateFlow(Color.Black)
    val changeRateColor: StateFlow<Color>
        get() = _changeRateColor

    suspend fun fetchCoinDetailInfo(marketName: String) {
        viewModelScope.launch {
            val result = getCoinDetailInfoUseCase(marketName)

            result
                .onSuccess { coinDetailInfo ->
                    val coinDetailModel = CoinDetailModel(
                        market = coinDetailInfo.market,
                        price = coinDetailInfo.prices.map {
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

    fun fetchTickerDetail(marketName: String) {
        viewModelScope.launch {
            getTickerDetailUseCase(TickerRequestEntity(TYPE, marketName))
                .collect { tickerDetailResponseEntity ->
                    updateTickerDetail(tickerDetailResponseEntity)
                }
        }
    }

    private fun updateTickerDetail(tickerDetailResponseEntity: TickerDetailResponseEntity) {
        val tickerDetail = TickerDetailModel(
            code = tickerDetailResponseEntity.code,
            tradePrice = tickerDetailResponseEntity.tradePrice,
            highPrice = tickerDetailResponseEntity.highPrice,
            lowPrice = tickerDetailResponseEntity.lowPrice,
            signedChangePrice = tickerDetailResponseEntity.signedChangePrice,
            signedChangeRate = tickerDetailResponseEntity.signedChangeRate
        )
        _tickerDetailInfo.value = tickerDetail
        changeRateColor(tickerDetailResponseEntity)
    }

    private fun changeRateColor(tickerDetailResponseEntity: TickerDetailResponseEntity) {
        _changeRateColor.value =
            if (tickerDetailResponseEntity.signedChangeRate!! < 0) Blue else Red
    }

    companion object {
        private const val TYPE = "ticker"
    }
}
