package com.coinkiri.coinkiri.domain.reissuetoken.repository

import com.coinkiri.coinkiri.domain.reissuetoken.entity.ReissueTokenResponseEntity

interface ReissueTokenRepository {
    suspend fun postReissueToken(
        refreshToken: String,
    ): Result<ReissueTokenResponseEntity>
}
