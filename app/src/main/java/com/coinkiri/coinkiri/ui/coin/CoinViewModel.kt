package com.coinkiri.coinkiri.ui.coin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.coin.entity.response.CoinResponseEntity
import com.coinkiri.coinkiri.domain.coin.entity.MergedCoinTickerEntity
import com.coinkiri.coinkiri.domain.coin.usecase.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinListUseCase: GetCoinListUseCase,
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
                }
                .onFailure { exception ->
                    "${exception.message}"
                }
        }
    }
}
