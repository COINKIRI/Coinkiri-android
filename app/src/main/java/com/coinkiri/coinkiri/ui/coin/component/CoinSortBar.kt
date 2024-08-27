package com.coinkiri.coinkiri.ui.coin.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme

@Composable
fun CoinSortBar(
    onSortByCoinNameClick: () -> Unit,
    onSortByCurrentPriceClick: () -> Unit,
    onSortByChangeRateClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
    ) {
        SortButton(
            onClick = onSortByCoinNameClick,
            btnText = "코인명 ⇅"
        )
        Spacer(Modifier.weight(1f))
        SortButton(
            onClick = onSortByCurrentPriceClick,
            btnText = "현재가 ⇅"
        )
        SortButton(
            onClick = onSortByChangeRateClick,
            btnText = "변동률 ⇅"
        )
    }
}

@Composable
fun SortButton(
    onClick: () -> Unit,
    btnText: String
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(3.dp),
        modifier = Modifier
            .height(25.dp)
            .padding(horizontal = 3.dp)
    ) {
        Text(
            text = btnText,
            color = Black,
            style = CoinkiriTheme.typography.labelSmall,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SortingBarPreview() {
    CoinkiriTheme {
        CoinSortBar(
            onSortByCoinNameClick = {},
            onSortByCurrentPriceClick = {},
            onSortByChangeRateClick = {}
        )
    }
}
