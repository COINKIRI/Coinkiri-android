package com.coinkiri.coinkiri.ui.talkdetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.component.common.CoinInfo
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray100
import com.coinkiri.coinkiri.core.designsystem.theme.Gray300
import com.coinkiri.coinkiri.core.designsystem.theme.Red

@Composable
fun SelectedCoinInfoItem(
    onCoinInfoItemClick: () -> Unit
) {
    Surface(
        onClick = onCoinInfoItemClick,
        shape = RoundedCornerShape(20.dp),
        color = Gray100,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                CoinInfo(
                    coinName = "비트코인",
                    coinSymbol = "BTC",
                    coinImage = R.drawable.btc
                )

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "₩ 100,000,000",
                        style = CoinkiriTheme.typography.bodyLarge
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "+ 12.1%",
                            style = CoinkiriTheme.typography.bodyMedium,
                            color = Red,
                        )
                        Text(
                            text = "▲ 54,321원",
                            style = CoinkiriTheme.typography.bodyMedium,
                            color = Red
                        )
                    }
                }
            }

            HorizontalDivider(
                color = Gray300,
                modifier = Modifier.padding(vertical = 5.dp)
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Outlined.QueryStats,
                    contentDescription = "chart Icon",
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Text(
                    text = "차트 확인하기",
                    color = Black,
                    style = CoinkiriTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun SelectedCoinInfoPreview() {
    CoinkiriTheme {
        SelectedCoinInfoItem(
            onCoinInfoItemClick = {}
        )
    }
}
