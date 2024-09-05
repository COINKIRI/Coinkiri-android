package com.coinkiri.coinkiri.domain.coin.entity.response

data class CoinDetailResponseEntity(
    val market: String,
    val prices: List<PriceResponseEntity>
)

data class PriceResponseEntity(
    val candleDateTimeKst: String,
    val tradePrice: Double
)
