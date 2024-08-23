package com.coinkiri.coinkiri.data.login.dto.request

import com.coinkiri.coinkiri.domain.login.entity.request.LoginRequestEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    @SerialName("platform")
    val platform: String
)

fun LoginRequestEntity.toLoginRequestDto(): LoginRequestDto =
    LoginRequestDto(platform)
