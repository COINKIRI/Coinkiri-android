package com.coinkiri.coinkiri.ui.coin.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme

@Composable
fun CoinChartItem() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "여기 차트")
    }
}

@Preview
@Composable
private fun CoinChartItemPreview() {
    CoinkiriTheme {
        CoinChartItem()
    }
}
