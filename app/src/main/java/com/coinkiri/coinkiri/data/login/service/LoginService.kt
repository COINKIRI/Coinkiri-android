package com.coinkiri.coinkiri.data.login.service

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.login.dto.request.LoginRequestDto
import com.coinkiri.coinkiri.data.login.dto.response.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginService {
    @POST("api/v1/auth/login")
    suspend fun postLogin(
        @Header("Authorization") accessToken: String,
        @Body body: LoginRequestDto,
    ): BaseResponse<LoginResponseDto>
}
