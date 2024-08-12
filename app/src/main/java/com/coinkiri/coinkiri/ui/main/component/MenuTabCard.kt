package com.coinkiri.coinkiri.ui.main.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.theme.Black
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.White

@Composable
fun MenuTabCard(
    @StringRes title: Int,
    @StringRes subTitle: Int,
    @DrawableRes cardImage: Int,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(White),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, start = 20.dp)
        ) {
            Text(
                text = stringResource(title),
                color = Black,
                fontWeight = FontWeight.Bold,
                style = CoinkiriTheme.typography.titleMedium
            )
            Text(
                text = stringResource(subTitle),
                color = Color.LightGray,
                fontWeight = FontWeight.SemiBold,
                style = CoinkiriTheme.typography.labelSmall
            )
        }

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(cardImage),
                contentDescription = ""
            )
        }
    }
}

@Preview
@Composable
fun PriceCardPreview() {
    CoinkiriTheme {
        MenuTabCard(
            title = R.string.price_check,
            subTitle = R.string.price_check_description,
            cardImage = R.drawable.img_main_coin_price,
            onClick = {},
            modifier = Modifier
                .size(160.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun BookCardPreview() {
    CoinkiriTheme {
        MenuTabCard(
            title = R.string.coin_book,
            subTitle = R.string.coin_book_description,
            cardImage = R.drawable.img_main_coin_book,
            onClick = {},
            modifier = Modifier
                .size(160.dp)
                .fillMaxWidth()
        )
    }
}