package com.coinkiri.coinkiri.data.ticker.repositoryimpl

import com.coinkiri.coinkiri.data.ticker.datasource.TickerDataSource
import com.coinkiri.coinkiri.data.ticker.mapper.toTickerEntity
import com.coinkiri.coinkiri.data.ticker.mapper.toTickerRequestDto
import com.coinkiri.coinkiri.domain.ticker.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.ticker.entity.response.TickerResponseEntity
import com.coinkiri.coinkiri.domain.ticker.repository.TickerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TickerRepositoryImpl @Inject constructor(
    private val tickerDataSource: TickerDataSource
) : TickerRepository {

    override fun getTickers(tickerRequestEntity: TickerRequestEntity): Flow<TickerResponseEntity> =
        tickerDataSource.getTickers(tickerRequestEntity.toTickerRequestDto())
            .map { tickerResponseDto ->
                tickerResponseDto.toTickerEntity()
            }

    override fun closeConnection() {
        tickerDataSource.closeConnection()
    }
}
