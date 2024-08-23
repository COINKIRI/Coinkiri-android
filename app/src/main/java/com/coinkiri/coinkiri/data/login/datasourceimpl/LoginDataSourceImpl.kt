package com.coinkiri.coinkiri.data.login.datasourceimpl

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.login.datasource.LoginDataSource
import com.coinkiri.coinkiri.data.login.dto.request.LoginRequestDto
import com.coinkiri.coinkiri.data.login.dto.response.LoginResponseDto
import com.coinkiri.coinkiri.data.login.service.LoginService
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val loginService: LoginService
) : LoginDataSource {

    override suspend fun postLogin(
        accessToken: String,
        platform: LoginRequestDto
    ): BaseResponse<LoginResponseDto> =
        loginService.postLogin(accessToken, platform)
}
