package com.coinkiri.coinkiri.ui.talkdetail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.talkdetail.component.ChatContent
import com.coinkiri.coinkiri.ui.talkdetail.component.ChatScreenTopBar

@Composable
fun TalkDetailScreen() {
    Scaffold(
        topBar = {
            ChatScreenTopBar()
        },
        content = { paddingValues -> // paddingValues 적용
            ChatContent(paddingValues)
        },
    )
}




@Preview
@Composable
private fun TalkDetailScreenPreview() {
    CoinkiriTheme {
        TalkDetailScreen()
    }
}
