package com.coinkiri.coinkiri.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.ui.designsystem.theme.White
import com.coinkiri.coinkiri.ui.home.component.CoinTalkMenuCard
import com.coinkiri.coinkiri.ui.home.component.MenuTabCard

@Composable
fun HomeScreen(
    onTalkClick: () -> Unit,
    onBookClick: () -> Unit,
    onPriceClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Scaffold(
        topBar = {
            HomeTopBar(
                onProfileClick = onProfileClick
            )
        },
        content = { innerPadding ->
            HomeScreenContent(
                innerPadding,
                onTalkClick = onTalkClick,
                onPriceClick = onPriceClick,
                onBookClick = onBookClick
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopBar(
    onProfileClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier,
        title = {
            Text(
                text = stringResource(id = R.string.kr_app_name),
                style = CoinkiriTheme.typography.yangJinHeadlineSmall
            )
        },
        actions = {
            IconButton(
                onClick = onProfileClick
            ) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = stringResource(id = R.string.profile)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = SemiBlue,
            titleContentColor = White,
            actionIconContentColor = White
        )
    )
}

@Composable
private fun HomeScreenContent(
    padding: PaddingValues,
    onTalkClick: () -> Unit,
    onBookClick: () -> Unit,
    onPriceClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .background(SemiBlue)
    ) {
        InfoSection()
        MenuSection(
            onTalkClick = onTalkClick,
            onBookClick = onBookClick,
            onPriceClick = onPriceClick
        )
    }
}

@Composable
private fun InfoSection(
    /*TODO text값 실 데이터 받아서 연결*/
) {
    Column(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 30.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "안녕하세요, 김영재님",
            color = White,
            fontWeight = FontWeight.Bold,
            style = CoinkiriTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "오늘은 00개의 코인이 상승중이네요!",
            color = White,
            fontWeight = FontWeight.SemiBold,
            style = CoinkiriTheme.typography.titleMedium
        )
        Text(
            text = "하락중인 코인은 000개에요!",
            color = White,
            fontWeight = FontWeight.SemiBold,
            style = CoinkiriTheme.typography.titleMedium,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun MenuSection(
    onBookClick: () -> Unit,
    onPriceClick: () -> Unit,
    onTalkClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        ) {
            CoinTalkMenuCard(
                onTalkClick = onTalkClick
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                MenuTabCard(
                    title = R.string.coin_book,
                    subTitle = R.string.coin_book_description,
                    cardImage = R.drawable.img_main_coin_book,
                    onClick = onBookClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .size(180.dp)
                )

                MenuTabCard(
                    title = R.string.price_check,
                    subTitle = R.string.price_check_description,
                    cardImage = R.drawable.img_main_coin_price,
                    onClick = onPriceClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .size(180.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    CoinkiriTheme {
        HomeScreen(
            onBookClick = {},
            onTalkClick = {},
            onPriceClick = {},
            onProfileClick = {}
        )
    }
}
