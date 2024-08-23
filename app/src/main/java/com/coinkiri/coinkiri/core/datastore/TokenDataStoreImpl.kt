package com.coinkiri.coinkiri.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

class TokenDataStoreImpl @Inject constructor(
    @Named("token") private val dataStore: DataStore<Preferences>,
) : TokenDataStore {

    private val accessTokenKey = stringPreferencesKey(ACCESS_TOKEN)
    private val refreshTokenKey = stringPreferencesKey(REFRESH_TOKEN)

    override val accessTokenFlow: Flow<String> = dataStore.data.map { preferences ->
        preferences[accessTokenKey] ?: ""
    }

    override val refreshTokenFlow: Flow<String> = dataStore.data.map { preferences ->
        preferences[refreshTokenKey] ?: ""
    }

    override suspend fun setAccessToken(value: String) {
        dataStore.edit { preferences ->
            preferences[accessTokenKey] = value
        }
    }

    override suspend fun setRefreshToken(value: String) {
        dataStore.edit { preferences ->
            preferences[refreshTokenKey] = value
        }
    }

    override suspend fun clearInfo() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private const val ACCESS_TOKEN = "ACCESS_TOKEN"
        private const val REFRESH_TOKEN = "REFRESH_TOKEN"
    }
}
