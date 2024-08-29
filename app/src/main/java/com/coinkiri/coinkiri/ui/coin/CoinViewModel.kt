package com.coinkiri.coinkiri.ui.coin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinkiri.coinkiri.domain.coin.entity.CoinResponseEntity
import com.coinkiri.coinkiri.domain.coin.usecase.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinListUseCase: GetCoinListUseCase
) : ViewModel() {

    private val _coinList = MutableStateFlow<List<CoinResponseEntity>>(emptyList())
    val coinList: StateFlow<List<CoinResponseEntity>>
        get() = _coinList

    fun fetchCoinList() {
        viewModelScope.launch {
            val result = getCoinListUseCase()

            result
                .onSuccess { coinList ->
                    _coinList.value = coinList
                }
                .onFailure { exception ->
                    "${exception.message}"
                }
        }
    }
}
