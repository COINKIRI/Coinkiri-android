package com.coinkiri.coinkiri.data.ticker.mapper

import com.coinkiri.coinkiri.data.ticker.dto.request.TickerRequestDto
import com.coinkiri.coinkiri.data.ticker.dto.response.TickerResponseDto
import com.coinkiri.coinkiri.domain.coin.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.coin.entity.response.TickerResponseEntity

fun TickerResponseDto.toTickerEntity(): TickerResponseEntity =
    TickerResponseEntity(
        code = code,
        tradePrice = tradePrice,
        signedChangeRate = signedChangeRate
    )

fun TickerRequestEntity.toTickerRequestDto(): TickerRequestDto =
    TickerRequestDto(
        codes = codes,
        type = type
    )
