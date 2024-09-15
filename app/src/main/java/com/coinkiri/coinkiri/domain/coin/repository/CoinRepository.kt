package com.coinkiri.coinkiri.domain.coin.repository

import com.coinkiri.coinkiri.domain.coin.entity.response.CoinCountResponseEntity
import com.coinkiri.coinkiri.domain.coin.entity.response.CoinDetailResponseEntity
import com.coinkiri.coinkiri.domain.coin.entity.response.CoinResponseEntity

interface CoinRepository {

    suspend fun getCoinList(): Result<List<CoinResponseEntity>>

    suspend fun getCoinDetail(market: String): Result<CoinDetailResponseEntity>

    suspend fun getCoinRiseAndFallCount(): Result<CoinCountResponseEntity>

}
