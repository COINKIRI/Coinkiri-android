package com.coinkiri.coinkiri.core.datastore

import kotlinx.coroutines.flow.Flow

interface TokenDataStore {
    val accessTokenFlow: Flow<String>
    val refreshTokenFlow: Flow<String>

    suspend fun setAccessToken(value: String)
    suspend fun setRefreshToken(value: String)

    suspend fun clearInfo()
}
