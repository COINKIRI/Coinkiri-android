package com.coinkiri.coinkiri.ui.main.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.ui.designsystem.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    onProfileIconClick: () -> Unit
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
                onClick = onProfileIconClick
            ) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = stringResource(id = R.string.my_page)
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