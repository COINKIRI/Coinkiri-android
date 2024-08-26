package com.coinkiri.coinkiri.ui.talk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray100
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.ui.talk.component.CoinTalkItem

@Composable
fun TalkScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TalkScreenTopBar(
                onBackClick = onBackClick,
                onSearchClick = {}
            )
        },
        content = { innerPadding ->
            TalkScreenContent(
                paddingValues = innerPadding
            )
        }
    )
}

@Composable
fun TalkScreenTopBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
) {
    CoinkiriTopBar(
        title = stringResource(id = R.string.coin_talk),
        isShowBackButton = true,
        isShowSearchButton = true,
        onBackClick = onBackClick,
        onSearchClick = onSearchClick,
    )
}

@Composable
fun TalkScreenContent(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(White)
            .fillMaxSize()
    ) {
        CoinTalkInfo()
        CoinTalkItems()
    }
}

@Composable
fun CoinTalkItems() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(30) {
            CoinTalkItem(
                onJoinChatButtonClick = {}
            )
        }
    }
}

@Composable
fun CoinTalkInfo() {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Gray100,
        modifier = Modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Text(text = "카로셀 추가예정")
        }
    }
}

@Preview
@Composable
fun CoinTalkItemPreview() {
    CoinkiriTheme {
        TalkScreen(
            onBackClick = {}
        )
    }
}
