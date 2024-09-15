package com.coinkiri.coinkiri.ui.profile.profileedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.coinkiri.coinkiri.core.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.ui.profile.model.UserInfoModel
import com.coinkiri.coinkiri.ui.profile.component.EditItem

@Composable
fun ProfileEditScreen(
    userInfo: UserInfoModel,
    onCloseClick: () -> Unit
) {
    Scaffold(
        topBar = {
            ProfileEditTopBar(
                onCloseClick = onCloseClick,
                onCompleteClick = {
                    // 완료 버튼
                }
            )
        },
        content = { padding ->
            ProfileEditContent(
                padding = padding,
                userInfo = userInfo
            )
        }
    )
}

@Composable
private fun ProfileEditTopBar(
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
private fun ProfileEditContent(
    padding: PaddingValues,
    userInfo: UserInfoModel,
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(White)
    ) {
        EditItem(
            userInfo = userInfo
        )
    }
}

@Preview
@Composable
fun ProfileEditScreenPreview() {
    ProfileEditScreen(
        onCloseClick = {},
        userInfo = UserInfoModel()
    )
}
