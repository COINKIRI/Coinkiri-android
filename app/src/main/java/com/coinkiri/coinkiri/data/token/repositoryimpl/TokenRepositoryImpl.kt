package com.coinkiri.coinkiri.data.token.repositoryimpl

import com.coinkiri.coinkiri.core.datastore.TokenDataStore
import com.coinkiri.coinkiri.domain.token.repository.TokenRepository
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenDataStore: TokenDataStore
) : TokenRepository {

    override fun getAccessToken(): String = runBlocking {
        tokenDataStore.accessTokenFlow.firstOrNull().orEmpty()
    }

    override fun getRefreshToken(): String = runBlocking {
        tokenDataStore.refreshTokenFlow.firstOrNull().orEmpty()
    }

    override fun setTokens(accessToken: String, refreshToken: String) = runBlocking {
        tokenDataStore.setAccessToken(accessToken)
        tokenDataStore.setRefreshToken(refreshToken)
    }

    override fun clearInfo() = runBlocking {
        tokenDataStore.clearInfo()
    }
}
