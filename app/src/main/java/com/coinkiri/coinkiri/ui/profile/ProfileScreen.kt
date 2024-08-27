package com.coinkiri.coinkiri.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.coinkiri.coinkiri.ui.profile.component.FirstSettingList
import com.coinkiri.coinkiri.ui.profile.component.ProfileImg
import com.coinkiri.coinkiri.ui.profile.component.SecondSettingList
import com.coinkiri.coinkiri.ui.profile.component.ThirdSettingList
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
            ProfileContent(padding)
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
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserInfoItem()
        Column(
            modifier = Modifier
                .padding(10.dp),
        ) {
            FirstSettingList()
            Spacer(modifier = Modifier.height(8.dp))
            SecondSettingList()
            Spacer(modifier = Modifier.height(8.dp))
            ThirdSettingList()
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    CoinkiriTheme {
        ProfileScreen(onBackClick = { Unit })
    }
}
