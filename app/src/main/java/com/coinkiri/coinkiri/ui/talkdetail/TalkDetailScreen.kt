package com.coinkiri.coinkiri.ui.talkdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.core.designsystem.component.bottombar.BottomTextField
import com.coinkiri.coinkiri.core.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.ui.talkdetail.component.SelectedCoinInfoItem

@Composable
fun TalkDetailScreen() {
    Scaffold(
        topBar = {
            TalkDetailTopBar(
                onBackClick = {}
            )
        },
        content = { paddingValues ->
            TalkDetailContent(paddingValues)
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

@Composable
private fun TalkDetailContent(
    paddingValues: PaddingValues
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(paddingValues)
            .padding(horizontal = 8.dp)
    ) {
        SelectedCoinInfoItem(
            onCoinInfoItemClick = {}
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            // TODO: talk 내용
        }
    }
}

@Preview
@Composable
private fun TalkDetailScreenPreview() {
    CoinkiriTheme {
        TalkDetailScreen()
    }
}
