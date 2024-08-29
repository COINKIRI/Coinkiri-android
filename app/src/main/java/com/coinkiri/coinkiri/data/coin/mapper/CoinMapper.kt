package com.coinkiri.coinkiri.data.coin.mapper

import com.coinkiri.coinkiri.data.coin.dto.response.CoinResponseDto
import com.coinkiri.coinkiri.domain.coin.entity.CoinResponseEntity

fun CoinResponseDto.toCoinEntity(): CoinResponseEntity =
    CoinResponseEntity(
        marketName = marketName,
        koreanName = koreanName,
        symbol = symbol
    )
