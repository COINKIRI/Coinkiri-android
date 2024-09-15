package com.coinkiri.coinkiri.data.user.mapper

import com.coinkiri.coinkiri.data.user.dto.UserResponseDto
import com.coinkiri.coinkiri.domain.user.entity.UserResponseEntity

fun UserResponseDto.toUserResponseEntity(): UserResponseEntity =
    UserResponseEntity(
        nickname = nickname,
        pic = pic
    )
