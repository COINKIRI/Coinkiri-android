package com.coinkiri.coinkiri.data.coin.mapper

import com.coinkiri.coinkiri.data.coin.dto.response.CoinDetailResponseDto
import com.coinkiri.coinkiri.data.coin.dto.response.PriceResponseDto
import com.coinkiri.coinkiri.domain.coin.entity.response.CoinDetailResponseEntity
import com.coinkiri.coinkiri.domain.coin.entity.response.PriceResponseEntity

fun CoinDetailResponseDto.toCoinDetailResponseEntity(): CoinDetailResponseEntity =
    CoinDetailResponseEntity(
        market = market,
        prices = prices.map { it.toPriceResponseEntity() }
    )

fun PriceResponseDto.toPriceResponseEntity(): PriceResponseEntity =
    PriceResponseEntity(
        candleDateTimeKst = candleDateTimeKst,
        tradePrice = tradePrice
    )
