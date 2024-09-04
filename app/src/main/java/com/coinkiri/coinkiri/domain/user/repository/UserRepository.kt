package com.coinkiri.coinkiri.domain.user.repository

import com.coinkiri.coinkiri.domain.user.entity.UserEntity

interface UserRepository {
    suspend fun getUserDetail(
        accessToken: String,
    ): Result<UserEntity>
}
