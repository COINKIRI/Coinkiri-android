package com.coinkiri.coinkiri.domain.ticker.entity.response

data class TickerResponseEntity(
    val code: String,
    val tradePrice: Double?,
    val signedChangeRate: Double?,
)
