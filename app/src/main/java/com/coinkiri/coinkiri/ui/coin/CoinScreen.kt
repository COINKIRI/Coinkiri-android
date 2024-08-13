package com.coinkiri.coinkiri.ui.coin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.ui.coin.component.CoinItem
import com.coinkiri.coinkiri.ui.coin.component.CoinScreenTopBar
import com.coinkiri.coinkiri.ui.coin.component.CoinSortBar
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.White

@Composable
fun CoinScreen() {
    Scaffold(
        topBar = {
            CoinScreenTopBar(
                onBackIconClick = {},
                onSearchIconClick = {}
            )
        },
        content = { innerPadding ->
            CoinScreenContent(innerPadding)
        }
    )
}

@Composable
fun CoinScreenContent(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(White)
            .padding(top = 8.dp)
            .fillMaxSize()
    ) {
        CoinSortBar(
            onSortByCoinNameClick = {},
            onSortByCurrentPriceClick = {},
            onSortByChangeRateClick = {}
        )
        CoinItems()
    }
}

@Composable
fun CoinItems() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(30) {
            CoinItem(
                onCoinItemClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoinScreenPreview() {
    CoinkiriTheme {
        CoinScreen()
    }
}
