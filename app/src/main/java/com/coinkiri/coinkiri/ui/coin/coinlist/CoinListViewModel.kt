package com.coinkiri.coinkiri.ui.coin.coinlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.ticker.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.ticker.entity.response.TickerResponseEntity
import com.coinkiri.coinkiri.domain.coin.usecase.GetCoinListUseCase
import com.coinkiri.coinkiri.domain.ticker.usecase.GetTickersUseCase
import com.coinkiri.coinkiri.ui.coin.model.CoinModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinListUseCase: GetCoinListUseCase,
    private val getTickersUseCase: GetTickersUseCase,
) : ViewModel() {

    private val _coinModel = MutableStateFlow<List<CoinModel>>(emptyList())
    val coinModel: StateFlow<List<CoinModel>>
        get() = _coinModel

    fun fetchCoinList() {
        viewModelScope.launch {
            val result = getCoinListUseCase()

            result
                .onSuccess { coinList ->
                    val initialCoinModel = coinList.map { coin ->
                        CoinModel(
                            marketName = coin.marketName,
                            koreanName = coin.koreanName,
                            symbol = coin.symbol,
                            tradePrice = null,
                            signedChangeRate = null
                        )
                    }
                    _coinModel.value = initialCoinModel
                    fetchTickers()
                }
                .onFailure { exception ->
                    "${exception.message}"
                }
        }
    }

    private fun fetchTickers() {
        val marketNames = _coinModel.value.joinToString(",") { "\"${it.marketName}\"" }
        Timber.e(marketNames)
        viewModelScope.launch {
            getTickersUseCase(TickerRequestEntity(TYPE, marketNames))
                .collect { tickerResponseEntity ->
                    updateTickers(listOf(tickerResponseEntity))
                }
        }
    }

    private fun updateTickers(tickers: List<TickerResponseEntity>) {
        val tickerMap = tickers.associateBy { it.code }
        val updatedList = _coinModel.value.map { coinModel ->
            val matchingTicker = tickerMap[coinModel.marketName]
            if (matchingTicker != null) {
                coinModel.copy(
                    tradePrice = matchingTicker.tradePrice,
                    signedChangeRate = matchingTicker.signedChangeRate
                )
            } else {
                coinModel
            }
        }
        _coinModel.value = updatedList
    }


    companion object {
        private const val TYPE = "ticker"
    }
}
