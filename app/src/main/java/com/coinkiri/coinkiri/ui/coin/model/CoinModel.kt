package com.coinkiri.coinkiri.ui.coin.model

data class CoinModel(
    val marketName: String = "",
    val koreanName: String = "",
    val symbol: String = "",
    val tradePrice: Double? = 0.0,
    val signedChangeRate: Double? = 0.0,
)
