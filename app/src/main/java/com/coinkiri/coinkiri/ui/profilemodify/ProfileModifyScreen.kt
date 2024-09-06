package com.coinkiri.coinkiri.ui.profilemodify

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.coinkiri.coinkiri.core.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.domain.user.entity.UserEntity
import com.coinkiri.coinkiri.ui.profilemodify.component.ProfileModifyItem

@Composable
fun ProfileModifyScreen(
    userInfo: UserEntity?,
) {
    Scaffold(
        containerColor = White,
        topBar = {
            ProfileModifyTopBar(
                onCloseClick = {
                    // 닫기 버튼
                },
                onCompleteClick = {
                    // 완료 버튼
                }
            )
        },
        content = { innerPadding ->
            ProfileModifyItem(
                padding = innerPadding,
                userInfo
            )
        }
    )
}

@Composable
private fun ProfileModifyTopBar(
    onCloseClick: () -> Unit,
    onCompleteClick: () -> Unit
) {
    CoinkiriTopBar(
        title = "프로필 변경",
        isShowCloseButton = true,
        isShowCompleteButton = true,
        onCloseClick = onCloseClick,
        onCompleteClick = onCompleteClick
    )
}

@Preview
@Composable
fun ProfileModifyScreenPreview() {
    ProfileModifyScreen(
        userInfo = UserEntity(
            pic = "",
            nickname = ""
        )
    )
}
