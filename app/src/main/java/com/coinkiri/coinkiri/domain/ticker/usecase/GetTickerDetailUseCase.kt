package com.coinkiri.coinkiri.domain.ticker.usecase

import com.coinkiri.coinkiri.domain.ticker.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.ticker.entity.response.TickerDetailResponseEntity
import com.coinkiri.coinkiri.domain.ticker.repository.TickerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTickerDetailUseCase @Inject constructor(
    private val tickerRepository: TickerRepository
) {
    operator fun invoke(tickerRequestEntity: TickerRequestEntity): Flow<TickerDetailResponseEntity> =
        tickerRepository.getTickerDetail(tickerRequestEntity)
}
