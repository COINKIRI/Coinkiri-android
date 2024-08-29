package com.coinkiri.coinkiri.data.coin.service

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.coin.dto.response.CoinResponseDto
import retrofit2.http.GET

interface CoinService {
    @GET("/api/v1/coin/all")
    suspend fun getCoinList(): BaseResponse<List<CoinResponseDto>>
}
