package com.coinkiri.coinkiri.ui.coin.coindetail

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.Blue
import com.coinkiri.coinkiri.core.designsystem.theme.Red
import com.coinkiri.coinkiri.core.util.Formatter.formattedPrice
import com.coinkiri.coinkiri.core.util.Formatter.formattedSignedChangeRate
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

    private val _reversedCoinInfo = MutableStateFlow<List<PriceModel>>(emptyList())
    val reversedCoinInfo: StateFlow<List<PriceModel>>
        get() = _reversedCoinInfo

    private val _tickerDetailInfo = MutableStateFlow(TickerDetailModel())
    val tickerDetailModel: StateFlow<TickerDetailModel>
        get() = _tickerDetailInfo

    private val _selectedPriceInfo = MutableStateFlow(PriceModel())
    val selectedPriceInfo: StateFlow<PriceModel>
        get() = _selectedPriceInfo

    private val _changeRateColor = MutableStateFlow(Black)
    val changeRateColor: StateFlow<Color>
        get() = _changeRateColor

    private val _maxValue = MutableStateFlow(0f)
    val maxValue: StateFlow<Float>
        get() = _maxValue

    private val _minValue = MutableStateFlow(0f)
    val minValue: StateFlow<Float>
        get() = _minValue

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
                    updateSelectedPriceInfo(coinDetailModel.price.reversed())
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

    fun updateSelectedPriceInfo(priceModel: PriceModel) {
        _selectedPriceInfo.value = PriceModel(
            candleDateTimeKst = priceModel.candleDateTimeKst,
            tradePrice = priceModel.tradePrice
        )
    }

    private fun updateTickerDetail(tickerDetailResponseEntity: TickerDetailResponseEntity) {
        val tickerDetail = TickerDetailModel(
            code = tickerDetailResponseEntity.code,
            tradePrice = formattedPrice(tickerDetailResponseEntity.tradePrice),
            highPrice = formattedPrice(tickerDetailResponseEntity.highPrice),
            lowPrice = formattedPrice(tickerDetailResponseEntity.lowPrice),
            signedChangePrice = formattedPrice(tickerDetailResponseEntity.signedChangePrice),
            signedChangeRate = formattedSignedChangeRate(tickerDetailResponseEntity.signedChangeRate)
        )
        _tickerDetailInfo.value = tickerDetail
        changeRateColor(tickerDetailResponseEntity)
    }

    private fun changeRateColor(tickerDetailResponseEntity: TickerDetailResponseEntity) {
        _changeRateColor.value =
            if (tickerDetailResponseEntity.signedChangeRate!! < NO_CHANGE_RATE) Blue else Red
    }

    private fun updateSelectedPriceInfo(priceList: List<PriceModel>) {
        _reversedCoinInfo.value = priceList
        calculateMinMaxValues(priceList)
    }

    private fun calculateMinMaxValues(priceList: List<PriceModel>) {
        _maxValue.value = priceList.maxOfOrNull { it.tradePrice.toFloat() } ?: 0f
        _minValue.value = priceList.minOfOrNull { it.tradePrice.toFloat() } ?: 0f
    }

    companion object {
        private const val TYPE = "ticker"
        private const val NO_CHANGE_RATE = 0
    }
}
