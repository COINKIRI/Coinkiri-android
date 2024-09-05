package com.coinkiri.coinkiri.data.user.mapper

import com.coinkiri.coinkiri.data.user.dto.UserResponseDto
import com.coinkiri.coinkiri.domain.user.entity.UserEntity

fun UserResponseDto.toUserEntity(): UserEntity =
    UserEntity(
        nickname = nickname,
        pic = pic
    )
