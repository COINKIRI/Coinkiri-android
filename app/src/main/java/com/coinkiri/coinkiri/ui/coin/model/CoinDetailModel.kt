package com.coinkiri.coinkiri.ui.coin.model

data class CoinDetailModel(
    val market: String = "",
    val price: List<PriceModel> = emptyList()
)

data class PriceModel(
    val candleDateTimeKst: String = "",
    val tradePrice: Double = 0.0
)
