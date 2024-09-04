package com.coinkiri.coinkiri.data.user.service

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.user.dto.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface UserService {
    @GET("api/v1/auth/info")
    suspend fun getUser(
        @Header("Authorization") accessToken: String
    ): BaseResponse<UserResponseDto>
}
