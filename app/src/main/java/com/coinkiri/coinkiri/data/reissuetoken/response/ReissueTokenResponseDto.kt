package com.coinkiri.coinkiri.data.reissuetoken.response

import com.coinkiri.coinkiri.domain.reissuetoken.entity.ReissueTokenResponseEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReissueTokenResponseDto(
    @SerialName("accessToken")
    val accessToken: String,
    @SerialName("refreshToken")
    val refreshToken: String
) {
    fun toReissueTokenResponseEntity() =
        ReissueTokenResponseEntity(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
}
