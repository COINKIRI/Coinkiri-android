package com.coinkiri.coinkiri.ui.coin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.coin.entity.MergedCoinTickerEntity
import com.coinkiri.coinkiri.domain.coin.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.coin.entity.response.TickerResponseEntity
import com.coinkiri.coinkiri.domain.coin.usecase.GetCoinListUseCase
import com.coinkiri.coinkiri.domain.coin.usecase.GetTicketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinListUseCase: GetCoinListUseCase,
    private val getTicketsUseCase: GetTicketsUseCase,
) : ViewModel() {

    private val _mergedCoinTickerList = MutableStateFlow<List<MergedCoinTickerEntity>>(emptyList())
    val mergedCoinTickerList: StateFlow<List<MergedCoinTickerEntity>>
        get() = _mergedCoinTickerList

    fun fetchCoinList() {
        viewModelScope.launch {
            val result = getCoinListUseCase()

            result
                .onSuccess { coinList ->
                    val initialMergedList = coinList.map { coin ->
                        MergedCoinTickerEntity(
                            marketName = coin.marketName,
                            koreanName = coin.koreanName,
                            symbol = coin.symbol,
                            tradePrice = null,
                            signedChangeRate = null
                        )
                    }
                    _mergedCoinTickerList.value = initialMergedList
                    fetchTickers()
                }
                .onFailure { exception ->
                    "${exception.message}"
                }
        }
    }

    private fun fetchTickers() {
        val marketNames = _mergedCoinTickerList.value.joinToString(",") { "\"${it.marketName}\"" }
        viewModelScope.launch {
            getTicketsUseCase(TickerRequestEntity(TYPE, marketNames))
                .collect { tickerResponseEntity ->
                    updateTickers(listOf(tickerResponseEntity))
                }
        }
    }

    private fun updateTickers(tickers: List<TickerResponseEntity>) {
        val updatedList = _mergedCoinTickerList.value.map { mergedCoinTicker ->
            val matchingTicker = tickers.find { it.code == mergedCoinTicker.marketName }
            if (matchingTicker != null) {
                mergedCoinTicker.copy(
                    tradePrice = matchingTicker.tradePrice,
                    signedChangeRate = matchingTicker.signedChangeRate
                )
            } else {
                mergedCoinTicker
            }
        }
        _mergedCoinTickerList.value = updatedList
    }

    companion object {
        private const val TYPE = "ticker"
    }
}
