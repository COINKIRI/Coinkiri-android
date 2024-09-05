package com.coinkiri.coinkiri.data.user.repositoryimpl

import com.coinkiri.coinkiri.data.user.datasource.UserDataSource
import com.coinkiri.coinkiri.data.user.mapper.toUserEntity
import com.coinkiri.coinkiri.domain.user.entity.UserEntity
import com.coinkiri.coinkiri.domain.user.repository.UserRepository
import jakarta.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun getUserDetail(): Result<UserEntity> = runCatching {
        val result = userDataSource.getUser()

        if (result.code == SUCCESS_CODE) {
            result.data.toUserEntity()
        } else {
            throw Exception("Failed to fetch userInfo: ${result.message}")
        }
    }

    companion object {
        private const val SUCCESS_CODE = "O001"
    }
}
