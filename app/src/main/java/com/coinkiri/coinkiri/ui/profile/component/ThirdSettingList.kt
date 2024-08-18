package com.coinkiri.coinkiri.ui.profile.component

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.ui.designsystem.theme.Black

@Composable
fun ThirdSettingList() {
    Card(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color(0xFFF4F4F4)),
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "약관 및 개인정보 취급방침", color = Black, modifier = Modifier
                    .weight(1f)
                    .wrapContentSize(Alignment.CenterStart)
            )
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = ">",
            )
        }
    }
}

@Preview
@Composable
fun ThirdSettingListPreview() {
    ThirdSettingList()
}
