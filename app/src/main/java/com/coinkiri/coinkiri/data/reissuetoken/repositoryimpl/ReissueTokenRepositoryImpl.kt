package com.coinkiri.coinkiri.data.reissuetoken.repositoryimpl

import com.coinkiri.coinkiri.data.reissuetoken.datasource.ReissueTokenDataSource
import com.coinkiri.coinkiri.domain.reissuetoken.entity.ReissueTokenResponseEntity
import com.coinkiri.coinkiri.domain.reissuetoken.repository.ReissueTokenRepository
import javax.inject.Inject

class ReissueTokenRepositoryImpl @Inject constructor(
    private val reissueTokenDataSource: ReissueTokenDataSource
) : ReissueTokenRepository {

    override suspend fun postReissueToken(
        refreshToken: String,
    ): Result<ReissueTokenResponseEntity> =
        runCatching {
            reissueTokenDataSource.postReissueToken(
                refreshToken,
            ).data.toReissueTokenResponseEntity()
        }
}
