package com.coinkiri.coinkiri.data.coin.mapper

import com.coinkiri.coinkiri.data.coin.dto.response.CoinCountResponseDto
import com.coinkiri.coinkiri.domain.coin.entity.response.CoinCountResponseEntity

fun CoinCountResponseDto.toCoinCountResponseEntity(): CoinCountResponseEntity =
    CoinCountResponseEntity(
        riseCount = riseCount,
        fallCount = fallCount
    )
