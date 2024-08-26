package com.coinkiri.coinkiri.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.White

@Composable
fun CoinTalkMenuCard(
    onTalkClick: () -> Unit
) {
    Card(
        onClick = onTalkClick,
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(White),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 5.dp, start = 15.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.img_main_talk),
                contentDescription = "",
                alignment = Alignment.Center,
                modifier = Modifier.size(70.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.coin_talk),
                    color = Black,
                    fontWeight = FontWeight.Bold,
                    style = CoinkiriTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(id = R.string.coin_talk_description),
                    color = Color.LightGray,
                    fontWeight = FontWeight.SemiBold,
                    style = CoinkiriTheme.typography.labelSmall
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        ) {
            CoinTalkItem()
            CoinTalkItem()
            CoinTalkItem()
            CoinTalkItem()
        }
    }
}

@Composable
fun CoinTalkItem(
    /*TODO 코인 심볼,이름, 메시지 실데이터 값 받아서 연결*/
) {
    Surface(
        shape = RoundedCornerShape(topStart = 23.dp, topEnd = 20.dp, bottomEnd = 20.dp),
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 15.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
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
                        painter = painterResource(R.drawable.btc),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "BTC",
                        style = CoinkiriTheme.typography.titleSmall
                    )
                    Text(
                        text = "비트코인",
                        style = CoinkiriTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.LightGray
                    )
                }
            }

            Text(
                text = "message",
                style = CoinkiriTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun CoinTalkItemPreview() {
    CoinkiriTheme {
        CoinTalkItem()
    }
}

@Preview
@Composable
fun CoinTalkMenuCardPreview() {
    CoinkiriTheme {
        CoinTalkMenuCard(
            onTalkClick = {}
        )
    }
}
