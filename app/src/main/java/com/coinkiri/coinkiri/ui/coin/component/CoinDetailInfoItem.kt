package com.coinkiri.coinkiri.ui.coin.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.core.designsystem.theme.Blue
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray500
import com.coinkiri.coinkiri.core.designsystem.theme.Red
import com.coinkiri.coinkiri.core.util.Formatter.formattedSignedChangeRate
import com.coinkiri.coinkiri.core.util.Formatter.formattedPrice
import com.coinkiri.coinkiri.core.util.Formatter.removeKrWPrefix
import com.coinkiri.coinkiri.core.util.byteArrayToPainter
import com.coinkiri.coinkiri.ui.coin.model.CoinModel
import com.coinkiri.coinkiri.ui.coin.model.TickerDetailModel

@Composable
fun CoinDetailInfoItem(
    coinModel: CoinModel,
    tickerDetailInfo: TickerDetailModel
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Image(
            painter = byteArrayToPainter(coinModel.symbol),
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(13.dp),
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = removeKrWPrefix(coinModel.marketName),
                    style = CoinkiriTheme.typography.titleLarge,
                )
                Text(
                    text = coinModel.koreanName,
                    color = Gray500,
                    style = CoinkiriTheme.typography.titleLarge,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
                    .padding(vertical = 6.dp)
            ) {
                Text(
                    text = "₩ " + formattedPrice(tickerDetailInfo.tradePrice),
                    style = CoinkiriTheme.typography.headlineMedium
                )
            }
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "증감률",
                color = Gray500,
                fontWeight = FontWeight.SemiBold,
                style = CoinkiriTheme.typography.bodyMedium,
            )
            Text(
                text = formattedSignedChangeRate(tickerDetailInfo.signedChangeRate),
                fontWeight = FontWeight.SemiBold,
                style = CoinkiriTheme.typography.bodyMedium,
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "증감액",
                color = Gray500,
                fontWeight = FontWeight.SemiBold,
                style = CoinkiriTheme.typography.bodyMedium,
            )
            Text(
                text = formattedPrice(tickerDetailInfo.signedChangePrice),
                fontWeight = FontWeight.SemiBold,
                style = CoinkiriTheme.typography.bodyMedium,
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "24H 고가",
                color = Gray500,
                fontWeight = FontWeight.SemiBold,
                style = CoinkiriTheme.typography.bodyMedium,
            )
            Text(
                text = formattedPrice(tickerDetailInfo.highPrice),
                fontWeight = FontWeight.SemiBold,
                color = Red,
                style = CoinkiriTheme.typography.bodyMedium,
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "24H 저가",
                color = Gray500,
                fontWeight = FontWeight.SemiBold,
                style = CoinkiriTheme.typography.bodyMedium,
            )
            Text(
                text = formattedPrice(tickerDetailInfo.lowPrice),
                fontWeight = FontWeight.SemiBold,
                color = Blue,
                style = CoinkiriTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CoinDetailInfoItemPreview() {
    CoinkiriTheme {
        CoinDetailInfoItem(
            coinModel = CoinModel(),
            tickerDetailInfo = TickerDetailModel()
        )
    }
}
