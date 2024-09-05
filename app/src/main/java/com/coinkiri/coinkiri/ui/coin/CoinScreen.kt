package com.coinkiri.coinkiri.ui.coin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.component.topappbar.CoinkiriTopBar
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.ui.coin.component.CoinItem
import com.coinkiri.coinkiri.ui.coin.component.CoinSortBar
import com.coinkiri.coinkiri.ui.coin.model.CoinModel

@Composable
fun CoinScreen(
    onBackClick: () -> Unit,
    onCoinItemClick: () -> Unit
) {
    val viewModel: CoinViewModel = hiltViewModel()
    val coinInfo by viewModel.coinModel.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.fetchCoinList()
    }

    Scaffold(
        topBar = {
            CoinScreenTopBar(
                onBackClick = onBackClick,
                onSearchClick = {}
            )
        },
        content = { innerPadding ->
            CoinScreenContent(
                padding = innerPadding,
                onCoinItemClick = onCoinItemClick
                coinInfo = coinInfo
            )
        }
    )
}

@Composable
private fun CoinScreenTopBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
) {
    CoinkiriTopBar(
        title = stringResource(id = R.string.price_check),
        isShowBackButton = true,
        isShowSearchButton = true,
        onBackClick = onBackClick,
        onSearchClick = onSearchClick
    )
}

@Composable
fun CoinScreenContent(
    padding: PaddingValues,
    onCoinItemClick: () -> Unit
    coinInfo: List<CoinModel>
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .background(White)
            .padding(top = 8.dp)
            .fillMaxSize()
    ) {
        CoinSortBar(
            onSortByCoinNameClick = {},
            onSortByCurrentPriceClick = {},
            onSortByChangeRateClick = {}
        )
        CoinItems(
            onCoinItemClick = onCoinItemClick
            coinInfo = coinInfo
        )
    }
}

@Composable
fun CoinItems(
    onCoinItemClick: () -> Unit
    coinInfo: List<CoinModel>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(coinInfo.size) { index ->
            val coin = coinInfo[index]
            CoinItem(
                coin = coin,
                onCoinItemClick = onCoinItemClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CoinScreenPreview() {
    CoinkiriTheme {
        CoinScreen(
            onBackClick = {},
            onCoinItemClick = {}
        )
    }
}
