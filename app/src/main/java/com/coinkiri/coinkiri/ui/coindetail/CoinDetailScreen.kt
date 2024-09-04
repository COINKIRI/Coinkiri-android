package com.coinkiri.coinkiri.ui.coindetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.core.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray200
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.ui.coindetail.component.CoinChartItem
import com.coinkiri.coinkiri.ui.coindetail.component.CoinDetailInfoItem
import com.coinkiri.coinkiri.ui.coindetail.component.NavigateToCoinTalkButton

@Composable
fun CoinDetailScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CoinDetailTopBar(
                onBackClick = onBackClick
            )
        },
        content = { paddingValues ->
            CoinDetailContent(
                padding = paddingValues
            )
        }
    )
}

@Composable
private fun CoinDetailTopBar(
    onBackClick: () -> Unit
) {
    CoinkiriTopBar(
        title = "상세정보",
        onBackClick = onBackClick,
        isShowBackButton = true
    )
}

@Composable
private fun CoinDetailContent(
    padding: PaddingValues
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(padding)
            .padding(horizontal = 10.dp)
    ) {
        CoinDetailInfoItem()
        HorizontalDivider(color = Gray200)
        NavigateToCoinTalkButton()
        CoinChartItem()
    }
}

@Preview
@Composable
private fun CoinDetailScreenPreview() {
    CoinkiriTheme {
        CoinDetailScreen(
            onBackClick = {}
        )
    }
}
