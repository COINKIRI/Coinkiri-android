package com.coinkiri.coinkiri.domain.user.repository

import com.coinkiri.coinkiri.domain.user.entity.UserResponseEntity

interface UserRepository {
    suspend fun getUser(): Result<UserResponseEntity>
}
