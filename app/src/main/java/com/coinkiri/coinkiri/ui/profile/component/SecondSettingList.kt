package com.coinkiri.coinkiri.ui.profile.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.core.designsystem.theme.Black

@Composable
fun SecondSettingList() {
    Column(
        modifier = Modifier
            .height(200.dp)
    ) {
        Card(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            colors = CardDefaults.cardColors(Color(0xFFF4F4F4)),
            modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth()
        ) {
            Text(
                text = "고객지원",
                color = Black,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .wrapContentSize(Alignment.CenterStart)
            )
        }
        Card(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = CardDefaults.cardColors(Color(0xFFF4F4F4)),
            modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "정보수정", color = Black, modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(Alignment.CenterStart)
                )
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = ">",
                )
            }
        }
        Card(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = CardDefaults.cardColors(Color(0xFFF4F4F4)),
            modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "로그아웃", color = Black, modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(Alignment.CenterStart)
                )
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = ">",
                )
            }
        }
        Card(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 10.dp,
                bottomEnd = 10.dp
            ),
            colors = CardDefaults.cardColors(Color(0xFFF4F4F4)),
            modifier = Modifier
                .weight(0.25f)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "회원탈퇴", color = Color.Red, modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(Alignment.CenterStart)
                )
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = ">",
                    tint = Color.Red
                )
            }
        }
    }
}

@Preview
@Composable
fun SecondSettingListPreview() {
    SecondSettingList()
}
