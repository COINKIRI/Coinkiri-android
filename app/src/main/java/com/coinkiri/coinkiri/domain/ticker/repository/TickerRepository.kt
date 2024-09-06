package com.coinkiri.coinkiri.domain.ticker.repository

import com.coinkiri.coinkiri.domain.ticker.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.ticker.entity.response.TickerResponseEntity
import kotlinx.coroutines.flow.Flow

interface TickerRepository {
    fun getTickers(tickerRequestEntity: TickerRequestEntity): Flow<TickerResponseEntity>
    fun closeConnection()
}
