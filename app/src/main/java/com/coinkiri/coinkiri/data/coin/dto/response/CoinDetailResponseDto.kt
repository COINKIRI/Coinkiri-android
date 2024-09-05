package com.coinkiri.coinkiri.data.coin.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailResponseDto(
    @SerialName("market")
    val market: String,
    @SerialName("prices")
    val prices: List<PriceResponseDto>
)

@Serializable
data class PriceResponseDto(
    @SerialName("candleDateTimeKst")
    val candleDateTimeKst: String,
    @SerialName("tradePrice")
    val tradePrice: Double
)
