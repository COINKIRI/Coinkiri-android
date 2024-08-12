package com.coinkiri.coinkiri.ui.coin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coinkiri.coinkiri.ui.designsystem.theme.White
import com.coinkiri.coinkiri.ui.designsystem.theme.Black
import com.coinkiri.coinkiri.ui.designsystem.theme.LightGray

@Composable
fun SortingBar() {
    Row(
        //horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(White),
    ) {

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = White, contentColor = Color.Gray),
            modifier = Modifier
                .width(100.dp),
        ) {
            Text(
                text = "코인명↑↓",
                fontSize = 8.sp,

                )
        }
        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        // 현재가 버튼
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = White, contentColor = Color.Gray),
        ) {
            Text(
                text = "현재가↑↓",
                fontSize = 8.sp
            )
        }

        // 변동률 버튼
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = White, contentColor = Color.Gray),
        ) {
            Text(
                text = "변동률↑↓",
                fontSize = 8.sp
            )
        }
    }
}

@Preview
@Composable
fun SortingBarPreview() {
    SortingBar()
}
