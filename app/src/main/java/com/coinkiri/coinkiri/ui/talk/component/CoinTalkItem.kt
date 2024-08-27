package com.coinkiri.coinkiri.ui.talk.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.component.button.JoinChatButton
import com.coinkiri.coinkiri.core.designsystem.component.common.CoinInfo
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray100

@Composable
fun CoinTalkItem(
    onJoinChatButtonClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(topStart = 23.dp, topEnd = 20.dp, bottomEnd = 20.dp),
        color = Gray100,
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 15.dp)
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
                JoinChatButton(
                    onClick = onJoinChatButtonClick,
                    buttonIcon = Icons.Default.Search,
                    buttonText = "코인톡참여"
                )
            }

            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "messagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessage",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = CoinkiriTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "000님",
                        style = CoinkiriTheme.typography.labelMedium
                    )
                    Text(
                        text = "5분전",
                        style = CoinkiriTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun CoinTalkItemPreview() {
    CoinkiriTheme {
        CoinTalkItem(
            onJoinChatButtonClick = {}
        )
    }
}
