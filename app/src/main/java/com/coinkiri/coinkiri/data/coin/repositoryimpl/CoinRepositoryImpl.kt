package com.coinkiri.coinkiri.data.coin.repositoryimpl

import com.coinkiri.coinkiri.data.coin.datasource.CoinDataSource
import com.coinkiri.coinkiri.data.coin.mapper.toCoinDetailResponseEntity
import com.coinkiri.coinkiri.data.coin.mapper.toCoinEntity
import com.coinkiri.coinkiri.domain.coin.entity.response.CoinDetailResponseEntity
import com.coinkiri.coinkiri.domain.coin.entity.response.CoinResponseEntity
import com.coinkiri.coinkiri.domain.coin.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinDataSource: CoinDataSource
) : CoinRepository {

    override suspend fun getCoinList(): Result<List<CoinResponseEntity>> = runCatching {
        val response = coinDataSource.getCoinList()

        if (response.code == SUCCESS_CODE) {
            response.data.map { coinResponseDto ->
                coinResponseDto.toCoinEntity()
            }
        } else {
            throw Exception("Failed to fetch coin list: ${response.message}")
        }
    }

    override suspend fun getCoinDetail(market: String): Result<CoinDetailResponseEntity> =
        runCatching {
            val response = coinDataSource.getCoinDetail(market)

            if (response.code == SUCCESS_CODE) {
                response.data.toCoinDetailResponseEntity()
            } else {
                throw Exception("Failed to fetch coin detail: ${response.message}")
            }
        }

    companion object {
        private const val SUCCESS_CODE = "O001"
    }
}
