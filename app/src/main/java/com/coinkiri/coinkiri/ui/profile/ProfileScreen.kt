package com.coinkiri.coinkiri.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.ui.profile.component.SettingOptionsItem
import com.coinkiri.coinkiri.ui.profile.component.OptionItem
import com.coinkiri.coinkiri.ui.profile.component.UserInfoItem

@Composable
fun ProfileScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            ProfileTopBar(
                onBackClick = onBackClick
            )
        },
        content = { padding ->
            ProfileContent(
                padding
            )
        }
    )
}

@Composable
private fun ProfileTopBar(
    onBackClick: () -> Unit
) {
    CoinkiriTopBar(
        title = stringResource(id = R.string.profile),
        isShowBackButton = true,
        onBackClick = onBackClick
    )
}

@Composable
private fun ProfileContent(
    padding: PaddingValues
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(White)
    ) {
        UserInfoItem()
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(10.dp),
        ) {
            SettingOptionsItem(
                title = "App 설정"
            ) {
                OptionItem(
                    text = "테마설정",
                    onOptionClick = { /*TODO*/ }
                )
            }
            SettingOptionsItem(
                title = "고객지원"
            ) {
                OptionItem(
                    text = "정보수정",
                    onOptionClick = { /*TODO*/ }
                )
                OptionItem(
                    text = "로그아웃",
                    onOptionClick = { /*TODO*/ }
                )
                OptionItem(
                    text = "회원탈퇴",
                    onOptionClick = { /*TODO*/ }
                )
            }
            SettingOptionsItem(
                title = "기타"
            ) {
                OptionItem(
                    text = "약관 및 개인정보 취급방침",
                    onOptionClick = { /*TODO*/ }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    CoinkiriTheme {
        ProfileScreen(
            onBackClick = { }
        )
    }
}
