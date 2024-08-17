package com.coinkiri.coinkiri.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.ui.designsystem.theme.White

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
            ProfileContent(padding)
        }
    )
}

@Composable
private fun ProfileTopBar(
    onBackClick: () -> Unit
) {
    CoinkiriTopBar(
        title = R.string.profile,
        isShowBackButton = true,
        onBackClick = onBackClick
    )
}

@Composable
private fun ProfileContent(
    padding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(White)
    ) {
        Text(text = "프로필화면")
    }
}
