package com.coinkiri.coinkiri.ui.talkdetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoGraph
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.theme.Black
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme

@Composable
fun SelectedCoinInfo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFF3F3F3))
            .padding(15.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.btc),
                contentDescription = "coinImage",
                modifier = Modifier.size(35.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "BTC",
                        style = CoinkiriTheme.typography.titleMedium
                    )
                    Text(
                        text = "비트코인",
                        style = CoinkiriTheme.typography.titleSmall
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "₩ 100,000,000",
                        style = CoinkiriTheme.typography.titleMedium
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "+ 12.1%",
                            style = CoinkiriTheme.typography.titleSmall,
                            color = Color.Red,
                        )
                        Text(
                            text = "▲ 54,321원",
                            style = CoinkiriTheme.typography.titleSmall,
                            color = Color.Red
                        )
                    }
                }
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 8.dp),
            color = Color(0xFFD8D8D8)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextButton(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(0.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Icon(
                        imageVector = Icons.Outlined.AutoGraph,
                        contentDescription = "차트아이콘",
                        tint = Black
                    )
                    Text(text = "차트 확인하기", color = Color.Black)
                }
            }
        }
    }
}

@Preview
@Composable
fun SelectedCoinInfoPreview() {
    CoinkiriTheme {
        SelectedCoinInfo()
    }
}
