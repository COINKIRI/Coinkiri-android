package com.coinkiri.coinkiri.domain.coin.repository

import com.coinkiri.coinkiri.domain.coin.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.coin.entity.response.TickerResponseEntity
import kotlinx.coroutines.flow.Flow

interface TickerRepository {
    fun getTickers(tickerRequestEntity: TickerRequestEntity): Flow<TickerResponseEntity>
    fun closeConnection()
}
