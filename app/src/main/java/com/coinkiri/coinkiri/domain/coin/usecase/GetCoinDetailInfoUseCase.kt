package com.coinkiri.coinkiri.domain.coin.usecase

import com.coinkiri.coinkiri.domain.coin.entity.response.CoinDetailResponseEntity
import com.coinkiri.coinkiri.domain.coin.repository.CoinRepository
import javax.inject.Inject

class GetCoinDetailInfoUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(market: String): Result<CoinDetailResponseEntity> =
        coinRepository.getCoinDetail(market)
}
