package com.coinkiri.coinkiri.data.reissuetoken.datasourceimpl

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.reissuetoken.datasource.ReissueTokenDataSource
import com.coinkiri.coinkiri.data.reissuetoken.response.ReissueTokenResponseDto
import com.coinkiri.coinkiri.data.reissuetoken.service.ReissueTokenService
import javax.inject.Inject

class ReissueTokenDataSourceImpl @Inject constructor(
    private val reissueTokenService: ReissueTokenService
) : ReissueTokenDataSource {

    override suspend fun postReissueToken(
        refreshToken: String
    ): BaseResponse<ReissueTokenResponseDto> =
        reissueTokenService.postReissueToken(refreshToken)
}
