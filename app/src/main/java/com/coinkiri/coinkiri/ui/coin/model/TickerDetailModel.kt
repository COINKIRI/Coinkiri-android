package com.coinkiri.coinkiri.ui.coin.model

data class TickerDetailModel(
    val code: String = "",
    val tradePrice: String = "",
    val highPrice: String = "",
    val lowPrice: String = "",
    val signedChangePrice: String = "",
    val signedChangeRate: String = ""
)
