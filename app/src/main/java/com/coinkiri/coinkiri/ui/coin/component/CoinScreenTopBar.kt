package com.coinkiri.coinkiri.ui.coin.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinScreenTopBar(
    onBackIconClick: () -> Unit,
    onSearchIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.coin_price),
                style = CoinkiriTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackIconClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "뒤로가기"
                )
            }
        },
        actions = {
            IconButton(
                onClick = onSearchIconClick
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "검색"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
            titleContentColor = Black,
            actionIconContentColor = Black
        )
    )
}

@Preview
@Composable
fun CoinScreenTopBarPreview() {
    CoinkiriTheme {
        CoinScreenTopBar(
            onBackIconClick = {},
            onSearchIconClick = {}
        )
    }
}
