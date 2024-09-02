package com.coinkiri.coinkiri.domain.coin.usecase

import com.coinkiri.coinkiri.domain.coin.entity.request.TickerRequestEntity
import com.coinkiri.coinkiri.domain.coin.entity.response.TickerResponseEntity
import com.coinkiri.coinkiri.domain.coin.repository.TickerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTicketsUseCase @Inject constructor(
    private val tickerRepository: TickerRepository
) {
    operator fun invoke(tickerRequestEntity: TickerRequestEntity): Flow<TickerResponseEntity> =
        tickerRepository.getTickers(tickerRequestEntity)
}
