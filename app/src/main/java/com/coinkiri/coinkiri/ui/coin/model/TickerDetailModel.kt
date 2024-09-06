package com.coinkiri.coinkiri.ui.coin.model

data class TickerDetailModel(
    val code: String = "",
    val tradePrice: Double? = 0.0,
    val highPrice: Double? = 0.0,
    val lowPrice: Double? = 0.0,
    val signedChangePrice: Double? = 0.0,
    val signedChangeRate: Double? = 0.0,
)
