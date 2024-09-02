package com.coinkiri.coinkiri.domain.coin.entity

data class MergedCoinTickerEntity(
    val marketName: String,
    val koreanName: String,
    val symbol: String,
    val tradePrice: Double?,
    val signedChangeRate: Double?,
)
