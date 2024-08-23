package com.coinkiri.coinkiri.data.login.datasource

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.login.dto.request.LoginRequestDto
import com.coinkiri.coinkiri.data.login.dto.response.LoginResponseDto

interface LoginDataSource {

    suspend fun postLogin(
        accessToken: String,
        platform: LoginRequestDto,
    ): BaseResponse<LoginResponseDto>
}
