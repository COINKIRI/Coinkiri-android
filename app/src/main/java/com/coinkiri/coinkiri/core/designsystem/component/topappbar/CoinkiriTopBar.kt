package com.coinkiri.coinkiri.core.designsystem.component.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Search
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
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinkiriTopBar(
    title: String,
    modifier: Modifier = Modifier,
    isShowBackButton: Boolean = false,
    isShowSearchButton: Boolean = false,
    onBackClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = CoinkiriTheme.typography.titleLarge
            )
        },
        modifier = modifier,
        navigationIcon = {
            if (isShowBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "back"
                    )
                }
            }
        },
        actions = {
            if (isShowSearchButton) {
                IconButton(onClick = onSearchClick) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search"
                    )
                }
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
fun CoinkiriTopBarPreview() {
    CoinkiriTheme {
        CoinkiriTopBar(
            title = stringResource(id = R.string.kr_app_name),
            isShowBackButton = true,
            isShowSearchButton = true
        )
    }
}
