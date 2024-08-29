package com.coinkiri.coinkiri.domain.coin.repository

import com.coinkiri.coinkiri.domain.coin.entity.CoinResponseEntity

interface CoinRepository {
    suspend fun getCoinList(): Result<List<CoinResponseEntity>>
}
