package com.coinkiri.coinkiri.data.user.service

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.user.dto.UserResponseDto
import retrofit2.http.GET

interface UserService {
    @GET("api/v1/auth/info")
    suspend fun getUser(): BaseResponse<UserResponseDto>
}
