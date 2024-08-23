package com.coinkiri.coinkiri.domain.login.repository

import com.coinkiri.coinkiri.domain.login.entity.reponse.LoginResponseEntity
import com.coinkiri.coinkiri.domain.login.entity.request.LoginRequestEntity

interface LoginRepository {
    suspend fun postLogin(
        accessToken: String,
        loginRequest: LoginRequestEntity
    ): Result<LoginResponseEntity>
}
