package com.coinkiri.coinkiri.data.reissuetoken.service

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.reissuetoken.response.ReissueTokenResponseDto
import retrofit2.http.Header
import retrofit2.http.POST

interface ReissueTokenService {
    @POST("/api/v1/auth/reissue")
    suspend fun postReissueToken(
        @Header("Authorization") refreshToken: String
    ): BaseResponse<ReissueTokenResponseDto>
}
