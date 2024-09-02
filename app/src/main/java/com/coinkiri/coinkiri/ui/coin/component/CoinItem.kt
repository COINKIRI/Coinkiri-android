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
import com.coinkiri.coinkiri.core.util.Formatter
import com.coinkiri.coinkiri.core.util.byteArrayToPainter
import com.coinkiri.coinkiri.domain.coin.entity.MergedCoinTickerEntity

@Composable
fun CoinItem(
    onCoinItemClick: () -> Unit,
    coin: MergedCoinTickerEntity
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clickable { onCoinItemClick }
            .padding(vertical = 5.dp, horizontal = 15.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Image(
                painter = byteArrayToPainter(coin.symbol),
                contentDescription = "coinSymbolImage",
                modifier = Modifier.size(24.dp)
            )

            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = coin.koreanName,
                    style = CoinkiriTheme.typography.titleSmall
                )
                Text(
                    text = coin.marketName,
                    style = CoinkiriTheme.typography.labelSmall
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "${Formatter.formattedTradePrice(coin.tradePrice)} 원",
                style = CoinkiriTheme.typography.titleMedium
            )
            Text(
                text = Formatter.formattedSignedChangeRate(coin.signedChangeRate),
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
private fun CoinItemPreview() {
    CoinkiriTheme {
        CoinItem(
            onCoinItemClick = {},
            coin = MergedCoinTickerEntity(
                marketName = "",
                symbol = "",
                koreanName = "",
                tradePrice = 0.0,
                signedChangeRate = 0.0
            )
        )
    }
}
