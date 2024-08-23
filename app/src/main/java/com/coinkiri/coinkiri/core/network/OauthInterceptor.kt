package com.coinkiri.coinkiri.core.network

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.coinkiri.coinkiri.core.datastore.TokenDataStore
import com.coinkiri.coinkiri.domain.reissuetoken.repository.ReissueTokenRepository
import com.jakewharton.processphoenix.ProcessPhoenix
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import javax.inject.Inject

class OauthInterceptor @Inject constructor(
    private val reissueTokenRepository: ReissueTokenRepository,
    private val dataStore: TokenDataStore,
    @ApplicationContext private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return runBlocking {
            val originalRequest = chain.request()
            val authRequest = addAuthorization(originalRequest)

            val response = chain.proceed(authRequest)
            if (response.code == TOKEN_EXPIRED) {
                handleTokenExpiration(chain, authRequest, response)
            } else {
                response
            }
        }
    }

    private suspend fun addAuthorization(request: Request): Request {
        val accessToken = dataStore.accessTokenFlow.firstOrNull().orEmpty()
        return if (accessToken.isNotBlank()) {
            request.newBuilder().addAuthorizationHeader(accessToken).build()
        } else {
            request
        }
    }

    private fun Request.Builder.addAuthorizationHeader(token: String) =
        this.addHeader(AUTHORIZATION, "$BEARER $token")

    private suspend fun handleTokenExpiration(
        chain: Interceptor.Chain,
        authRequest: Request,
        response: Response
    ): Response {
        response.close()
        return if (tryReissueToken()) {
            val newAccessToken = dataStore.accessTokenFlow.firstOrNull().orEmpty()
            val newRequest = authRequest.newBuilder()
                .addAuthorizationHeader(newAccessToken)
                .build()
            chain.proceed(newRequest)
        } else {
            clearUserInfoAndRestart()
            chain.proceed(authRequest.newBuilder().build())
        }
    }

    private suspend fun tryReissueToken(): Boolean {
        return try {
            val refreshToken = dataStore.refreshTokenFlow.firstOrNull().orEmpty()
            val result = reissueTokenRepository.postReissueToken("$BEARER $refreshToken")
            result.onSuccess { data ->
                Timber.d("Successfully reissued token: ${data.refreshToken}")
                updateTokens(data.accessToken, data.refreshToken)
            }.onFailure { error ->
                Timber.e("Failed to reissue token: $error")
            }
            result.isSuccess
        } catch (t: Throwable) {
            Timber.e(t, "Exception occurred while reissuing token")
            false
        }
    }

    private suspend fun updateTokens(newAccessToken: String, newRefreshToken: String) {
        Timber.e("NEW ACCESS TOKEN : $newAccessToken")
        Timber.e("NEW REFRESH TOKEN : $newRefreshToken")
        withContext(Dispatchers.IO) {
            dataStore.setAccessToken(newAccessToken)
            dataStore.setRefreshToken(newRefreshToken)
        }
    }

    private fun clearUserInfoAndRestart() {
        runBlocking {
            dataStore.clearInfo()
        }
        Handler(Looper.getMainLooper()).post {
            ProcessPhoenix.triggerRebirth(context)
        }
    }

    companion object {
        private const val TOKEN_EXPIRED = 401
        private const val BEARER = "Bearer"
        private const val AUTHORIZATION = "Authorization"
    }
}
