package com.coinkiri.coinkiri.ui.coindetail.component

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray500

@Composable
fun CoinDetailInfoItem() {
    Row(
        modifier = Modifier.padding(
            vertical = 10.dp,
            horizontal = 10.dp
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.btc),
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(13.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = "BTC",
                    style = CoinkiriTheme.typography.titleLarge,
                )
                Text(
                    text = "비트코인",
                    color = Gray500,
                    style = CoinkiriTheme.typography.titleLarge,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = "100,000,000",
                    style = CoinkiriTheme.typography.headlineLarge
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Column() {
                    Text(
                        text = "증감률",
                        color = Gray500,
                        fontWeight = FontWeight.SemiBold,
                        style = CoinkiriTheme.typography.labelMedium,
                    )
                    Text(
                        text = "+ 12.4%",
                        style = CoinkiriTheme.typography.labelMedium,
                    )
                }
                Column() {
                    Text(
                        text = "증감액",
                        color = Gray500,
                        fontWeight = FontWeight.SemiBold,
                        style = CoinkiriTheme.typography.labelMedium,
                    )
                    Text(
                        text = "▴ 59,000",
                        style = CoinkiriTheme.typography.labelMedium,
                    )
                }
                Column() {
                    Text(
                        text = "24H 고가",
                        color = Gray500,
                        fontWeight = FontWeight.SemiBold,
                        style = CoinkiriTheme.typography.labelMedium,
                    )
                    Text(
                        text = "100,000,000",
                        style = CoinkiriTheme.typography.labelMedium,
                    )
                }
                Column() {
                    Text(
                        text = "24H 저가",
                        color = Gray500,
                        fontWeight = FontWeight.SemiBold,
                        style = CoinkiriTheme.typography.labelMedium,
                    )
                    Text(
                        text = "100,000,000",
                        style = CoinkiriTheme.typography.labelMedium,
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CoinDetailInfoItemPreview() {
    CoinkiriTheme {
        CoinDetailInfoItem()
    }
}
