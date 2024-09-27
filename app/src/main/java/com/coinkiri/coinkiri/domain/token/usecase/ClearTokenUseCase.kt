package com.coinkiri.coinkiri.domain.token.usecase

import com.coinkiri.coinkiri.domain.token.repository.TokenRepository
import javax.inject.Inject

class ClearTokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    operator fun invoke() = tokenRepository.clearInfo()
}
