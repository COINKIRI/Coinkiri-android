package com.coinkiri.coinkiri.data.coin.service

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.coin.dto.response.CoinDetailResponseDto
import com.coinkiri.coinkiri.data.coin.dto.response.CoinResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinService {
    @GET("/api/v1/coin/all")
    suspend fun getCoinList(): BaseResponse<List<CoinResponseDto>>

    @GET("/api/v1/coin/detail")
    suspend fun getCoinDetailInfo(
        @Query("market") market: String
    ): BaseResponse<CoinDetailResponseDto>
}
