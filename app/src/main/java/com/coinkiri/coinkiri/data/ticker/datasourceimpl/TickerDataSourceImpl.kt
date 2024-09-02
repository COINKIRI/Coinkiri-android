package com.coinkiri.coinkiri.data.ticker.datasourceimpl

import com.coinkiri.coinkiri.data.ticker.datasource.TickerDataSource
import com.coinkiri.coinkiri.data.ticker.dto.request.TickerRequestDto
import com.coinkiri.coinkiri.data.ticker.dto.response.TickerResponseDto
import com.coinkiri.coinkiri.data.ticker.service.TickerService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TickerDataSourceImpl @Inject constructor(
    private val tickerService: TickerService,
) : TickerDataSource {

    override fun getTickers(tickerRequestDto: TickerRequestDto): Flow<TickerResponseDto> =
        tickerService.startConnection(tickerRequestDto)

    override fun closeConnection() {
        tickerService.closeConnection()
    }
}
