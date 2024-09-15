package com.coinkiri.coinkiri.domain.coin.usecase

import com.coinkiri.coinkiri.domain.coin.entity.response.CoinCountResponseEntity
import com.coinkiri.coinkiri.domain.coin.repository.CoinRepository
import javax.inject.Inject

class GetCoinRiseAndFallCountUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(): Result<CoinCountResponseEntity> =
        coinRepository.getCoinRiseAndFallCount()
}
