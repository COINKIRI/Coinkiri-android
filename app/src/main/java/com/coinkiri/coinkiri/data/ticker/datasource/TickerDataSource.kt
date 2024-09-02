package com.coinkiri.coinkiri.data.ticker.datasource

import com.coinkiri.coinkiri.data.ticker.dto.request.TickerRequestDto
import com.coinkiri.coinkiri.data.ticker.dto.response.TickerResponseDto
import kotlinx.coroutines.flow.Flow

interface TickerDataSource {
    fun getTickers(tickerRequestDto: TickerRequestDto): Flow<TickerResponseDto>
    fun closeConnection()
}
