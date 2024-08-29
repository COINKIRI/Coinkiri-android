package com.coinkiri.coinkiri.data.coin.datasource

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.coin.dto.response.CoinResponseDto

interface CoinDataSource {
    suspend fun getCoinList(): BaseResponse<List<CoinResponseDto>>
}
