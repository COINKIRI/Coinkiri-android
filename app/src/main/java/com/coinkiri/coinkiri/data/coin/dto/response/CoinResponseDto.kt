package com.coinkiri.coinkiri.data.coin.dto.response

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinResponseDto(
    @SerialName("marketName")
    val marketName: String,
    @SerialName("koreanName")
    val koreanName: String,
    @SerialName("englishName")
    val englishName: String,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("createdAt")
    val createdAt: LocalDateTime
)
