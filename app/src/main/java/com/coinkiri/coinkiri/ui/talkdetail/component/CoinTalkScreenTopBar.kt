package com.coinkiri.coinkiri.ui.talkdetail.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinTalkScreenTopBar() {
    TopAppBar(
        title = {
            Text(text = "비트코인톡", fontSize = 20.sp)
        },
        navigationIcon = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "채팅퇴장하기"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(Color.White)

    )

}


@Preview
@Composable
fun CoinTalkScreenTopBarPreview() {
    CoinTalkScreenTopBar()
}