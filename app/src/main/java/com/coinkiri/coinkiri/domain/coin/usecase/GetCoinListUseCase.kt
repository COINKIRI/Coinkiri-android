package com.coinkiri.coinkiri.domain.coin.usecase

import com.coinkiri.coinkiri.domain.coin.entity.response.CoinResponseEntity
import com.coinkiri.coinkiri.domain.coin.repository.CoinRepository
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    suspend operator fun invoke(): Result<List<CoinResponseEntity>> =
        coinRepository.getCoinList()
}
