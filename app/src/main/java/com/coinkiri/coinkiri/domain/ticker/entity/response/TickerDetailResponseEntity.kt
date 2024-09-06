package com.coinkiri.coinkiri.domain.ticker.entity.response

data class TickerDetailResponseEntity(
    val code: String,
    val tradePrice: Double?,
    val highPrice: Double?,
    val lowPrice: Double?,
    val signedChangePrice: Double?,
    val signedChangeRate: Double?,
)
