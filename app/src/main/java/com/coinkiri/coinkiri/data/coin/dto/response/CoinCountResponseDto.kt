package com.coinkiri.coinkiri.data.coin.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinCountResponseDto(
    @SerialName("riseCount")
    val riseCount: Int,
    @SerialName("fallCount")
    val fallCount: Int
)
