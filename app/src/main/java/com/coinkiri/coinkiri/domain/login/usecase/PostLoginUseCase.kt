package com.coinkiri.coinkiri.domain.login.usecase

import com.coinkiri.coinkiri.domain.login.entity.request.LoginRequestEntity
import com.coinkiri.coinkiri.domain.login.repository.LoginRepository
import javax.inject.Inject

class PostLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(accessToken: String, platform: String) =
        loginRepository.postLogin(accessToken, LoginRequestEntity(platform))
}
