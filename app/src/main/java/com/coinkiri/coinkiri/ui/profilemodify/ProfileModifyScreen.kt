package com.coinkiri.coinkiri.ui.profilemodify

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.coinkiri.coinkiri.core.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.domain.user.entity.UserResponseEntity
import com.coinkiri.coinkiri.ui.profile.model.UserInfoModel
import com.coinkiri.coinkiri.ui.profilemodify.component.ProfileModifyItem

@Composable
fun ProfileModifyScreen(
    userInfo: UserInfoModel,
    onCloseClick: () -> Unit
) {
    Scaffold(
        topBar = {
            ProfileModifyTopBar(
                onCloseClick = onCloseClick,
                onCompleteClick = {
                    // 완료 버튼
                }
            )
        },
        content = { padding ->
            ProfileModifyContent(
                padding = padding,
                userInfo = userInfo
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

@Composable
private fun ProfileModifyContent(
    padding: PaddingValues,
    userInfo: UserInfoModel,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        ProfileModifyItem(
            padding = padding,
            userInfo = userInfo
        )
    }
}

@Preview
@Composable
fun ProfileModifyScreenPreview() {
    ProfileModifyScreen(
        onCloseClick = {},
        userInfo = UserInfoModel()
    )
}
