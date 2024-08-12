package com.coinkiri.coinkiri.ui.coin.component

import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.unit.sp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.theme.Black
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.ui.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinScreenTopBar(
    onProfileIconClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier,
        title = {
            Text(
                text = stringResource(id = R.string.coin_price_topbar),
                fontSize = 20.sp,
                style = CoinkiriTheme.typography.yangJinHeadlineSmall
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "뒤로가기"
                )

            }
        },
        actions = {
            IconButton(
                onClick = onProfileIconClick
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