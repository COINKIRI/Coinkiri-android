package com.coinkiri.coinkiri.domain.token.usecase

import com.coinkiri.coinkiri.domain.token.repository.TokenRepository
import javax.inject.Inject

class SetTokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    operator fun invoke(accessToken: String, refreshToken: String) =
        tokenRepository.setTokens(accessToken, refreshToken)
}
