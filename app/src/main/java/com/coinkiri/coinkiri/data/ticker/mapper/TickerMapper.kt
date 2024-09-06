package com.coinkiri.coinkiri.data.ticker.mapper

import com.coinkiri.coinkiri.data.ticker.dto.request.TickerRequestDto
import com.coinkiri.coinkiri.data.ticker.dto.response.TickerResponseDto
import com.coinkiri.coinkiri.domain.ticker.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.ticker.entity.response.TickerDetailResponseEntity
import com.coinkiri.coinkiri.domain.ticker.entity.response.TickerResponseEntity

fun TickerResponseDto.toTickerEntity(): TickerResponseEntity =
    TickerResponseEntity(
        code = code,
        tradePrice = tradePrice,
        signedChangeRate = signedChangeRate
    )

fun TickerResponseDto.toTickerDetailEntity(): TickerDetailResponseEntity =
    TickerDetailResponseEntity(
        code = code,
        tradePrice = tradePrice,
        highPrice = highPrice,
        lowPrice = lowPrice,
        signedChangePrice = signedChangePrice,
        signedChangeRate = signedChangeRate
    )

fun TickerRequestEntity.toTickerRequestDto(): TickerRequestDto =
    TickerRequestDto(
        codes = codes,
        type = type
    )
