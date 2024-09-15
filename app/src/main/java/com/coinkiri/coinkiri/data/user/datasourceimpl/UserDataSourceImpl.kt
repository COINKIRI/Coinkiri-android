package com.coinkiri.coinkiri.data.user.datasourceimpl

import com.coinkiri.coinkiri.core.network.BaseResponse
import com.coinkiri.coinkiri.data.user.datasource.UserDataSource
import com.coinkiri.coinkiri.data.user.dto.UserResponseDto
import com.coinkiri.coinkiri.data.user.service.UserService
import jakarta.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userService: UserService
) : UserDataSource {

    override suspend fun getUser(): BaseResponse<UserResponseDto> =
        userService.getUser()

}
