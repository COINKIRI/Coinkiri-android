package com.coinkiri.coinkiri.ui.coin.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.util.byteArrayToPainter
import com.coinkiri.coinkiri.domain.coin.entity.CoinResponseEntity

@Composable
fun CoinItem(
    onCoinItemClick: () -> Unit,
    coin: CoinResponseEntity
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clickable { onCoinItemClick }
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Image(
                painter = byteArrayToPainter(coin.symbol),
                contentDescription = "coinSymbolImage",
                modifier = Modifier.size(35.dp)
            )

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = coin.marketName,
                    style = CoinkiriTheme.typography.titleMedium
                )
                Text(
                    text = coin.koreanName,
                    style = CoinkiriTheme.typography.titleSmall
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "₩ 100,000,000",
                style = CoinkiriTheme.typography.titleMedium
            )
            Text(
                text = "+ 12.1%",
                style = CoinkiriTheme.typography.titleSmall
            )
        }
    }

    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 8.dp),
        color = Color.LightGray
    )
}

@Preview(showBackground = true)
@Composable
fun CoinItemPreview() {
    CoinkiriTheme {
        CoinItem(
            onCoinItemClick = {},
            coin = CoinResponseEntity(
                marketName = "",
                koreanName = "",
                symbol = ""
            )
        )
    }
}
