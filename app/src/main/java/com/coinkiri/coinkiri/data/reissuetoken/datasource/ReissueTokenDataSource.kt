package com.coinkiri.coinkiri.data.reissuetoken.datasource

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.reissuetoken.response.ReissueTokenResponseDto

interface ReissueTokenDataSource {

    suspend fun postReissueToken(
        refreshToken: String
    ): BaseResponse<ReissueTokenResponseDto>
}
