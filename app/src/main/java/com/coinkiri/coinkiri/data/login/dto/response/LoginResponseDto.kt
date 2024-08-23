package com.coinkiri.coinkiri.data.login.dto.response

import com.coinkiri.coinkiri.domain.login.entity.reponse.LoginResponseEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    @SerialName("accessToken")
    val accessToken: String,
    @SerialName("refreshToken")
    val refreshToken: String
) {
    fun toLoginEntity() =
        LoginResponseEntity(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
}
