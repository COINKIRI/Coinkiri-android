package com.coinkiri.coinkiri.data.user.datasource

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.user.dto.UserResponseDto

interface UserDataSource {
    suspend fun getUser(accessToken: String): BaseResponse<UserResponseDto>
}