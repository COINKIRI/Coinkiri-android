package com.coinkiri.coinkiri.ui.talkdetail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.coinkiri.coinkiri.core.designsystem.component.bottombar.BottomTextField
import com.coinkiri.coinkiri.core.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.talkdetail.component.ChatContent

@Composable
fun TalkDetailScreen() {
    Scaffold(
        topBar = {
            TalkDetailTopBar(
                onBackClick = {}
            )
        },
        content = { paddingValues -> // paddingValues 적용
            ChatContent(paddingValues)
        },
        bottomBar = {
            BottomTextField()
        }
    )
}

@Composable
private fun TalkDetailTopBar(
    onBackClick: () -> Unit
) {
    CoinkiriTopBar(
        title = "비트코인톡",
        isShowBackButton = true,
        onBackClick = onBackClick
    )
}



@Preview
@Composable
private fun TalkDetailScreenPreview() {
    CoinkiriTheme {
        TalkDetailScreen()
    }
}
