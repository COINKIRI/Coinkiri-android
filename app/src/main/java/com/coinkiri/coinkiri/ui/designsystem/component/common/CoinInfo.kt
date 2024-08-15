package com.coinkiri.coinkiri.ui.designsystem.component.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.Gray400
import com.coinkiri.coinkiri.ui.designsystem.theme.White

@Composable
fun CoinInfo(
    coinName: String,
    coinSymbol: String,
    @DrawableRes coinImage: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Surface(
            shape = CircleShape,
            color = White
        ) {
            Image(
                painter = painterResource(coinImage),
                contentDescription = "coin image",
                modifier = Modifier.size(30.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = coinSymbol,
                style = CoinkiriTheme.typography.titleSmall
            )
            Text(
                text = coinName,
                style = CoinkiriTheme.typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                color = Gray400
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoinInfoPreview() {
    CoinInfo(
        coinName = "비트코인",
        coinSymbol = "BTC",
        coinImage = R.drawable.btc
    )
}
