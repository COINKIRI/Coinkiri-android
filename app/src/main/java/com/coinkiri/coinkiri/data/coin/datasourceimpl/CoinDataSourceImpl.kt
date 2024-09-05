package com.coinkiri.coinkiri.data.coin.datasourceimpl

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.coin.datasource.CoinDataSource
import com.coinkiri.coinkiri.data.coin.dto.response.CoinDetailResponseDto
import com.coinkiri.coinkiri.data.coin.dto.response.CoinResponseDto
import com.coinkiri.coinkiri.data.coin.service.CoinService
import javax.inject.Inject

class CoinDataSourceImpl @Inject constructor(
    private val coinService: CoinService
) : CoinDataSource {

    override suspend fun getCoinList(): BaseResponse<List<CoinResponseDto>> =
        coinService.getCoinList()

    override suspend fun getCoinDetail(market: String): BaseResponse<CoinDetailResponseDto> =
        coinService.getCoinDetailInfo(market)
}
