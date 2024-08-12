package com.coinkiri.coinkiri.ui.coin

import android.graphics.fonts.Font
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.coin.component.CoinScreenTopBar
import com.coinkiri.coinkiri.ui.coin.component.SortingBar
import com.coinkiri.coinkiri.ui.designsystem.theme.Black
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.White
import java.text.DecimalFormat

@Composable
fun CoinScreen() {
    Scaffold(
        topBar = {
            CoinScreenTopBar {

            }

        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
            ) {
                SortingBar()
                CoinItemList()
            }

        }
    )
}


@Composable
fun CoinItemList() {
    LazyColumn() {
        items(30) {
            CoinItem()

        }


    }


}


@Composable
fun CoinItem() {
    var coinPrice = 100000
    var coinPercent = 7.1

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(White)
            .padding(vertical = 5.dp, horizontal = 8.dp)
            .drawBehind {
                drawBottomUnderline(1.dp, Color.LightGray) // 두께와 색상 조정
            }
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.btc),
                contentDescription = "btcImg",
                modifier = Modifier
                    .size(40.dp)
            )

            Column(
                modifier = Modifier
                    .width(70.dp)
                    .fillMaxHeight()
            ) {
                Text(text = "BTC", fontSize = 18.sp)
                Text(text = "비트코인", fontWeight = FontWeight.Thin)
            }
        }

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxHeight(),
            //verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "₩${DecimalFormat("#,###").format(coinPrice)}", fontSize = 18.sp)
            Text(text = "+${coinPercent}%")
        }


    }
}

/*TODO 테두리*/
private fun DrawScope.drawBottomUnderline(thickness: Dp, color: Color) {
    val strokeWidthPx = thickness.toPx()
    drawRect(
        color = color,
        size = androidx.compose.ui.geometry.Size(
            width = size.width,
            height = strokeWidthPx
        ),
        topLeft = androidx.compose.ui.geometry.Offset(0f, size.height - strokeWidthPx)
    )
}


@Preview
@Composable
fun CoinScreenPreview() {
    CoinkiriTheme {
        CoinScreen()
    }

}
