package com.coinkiri.coinkiri.data.user.repositoryimpl

import com.coinkiri.coinkiri.data.user.datasource.UserDataSource
import com.coinkiri.coinkiri.data.user.mapper.toUserResponseEntity
import com.coinkiri.coinkiri.domain.user.entity.UserResponseEntity
import com.coinkiri.coinkiri.domain.user.repository.UserRepository
import jakarta.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {

    override suspend fun getUser(): Result<UserResponseEntity> =
        runCatching {
            val result = userDataSource.getUser()

            if (result.code == SUCCESS_CODE) {
                result.data.toUserResponseEntity()
            } else {
                throw Exception("Failed to fetch userInfo: ${result.message}")
            }
        }

    companion object {
        private const val SUCCESS_CODE = "O001"
    }
}
