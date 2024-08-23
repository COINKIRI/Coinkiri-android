package com.coinkiri.coinkiri.data.login.repositoryimpl

import com.coinkiri.coinkiri.data.login.datasource.LoginDataSource
import com.coinkiri.coinkiri.data.login.dto.request.toLoginRequestDto
import com.coinkiri.coinkiri.domain.login.entity.reponse.LoginResponseEntity
import com.coinkiri.coinkiri.domain.login.entity.request.LoginRequestEntity
import com.coinkiri.coinkiri.domain.login.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource,
) : LoginRepository {

    override suspend fun postLogin(
        accessToken: String,
        loginRequest: LoginRequestEntity
    ): Result<LoginResponseEntity> = runCatching {
        loginDataSource.postLogin(
            accessToken,
            loginRequest.toLoginRequestDto(),
        ).data.toLoginEntity()
    }
}
