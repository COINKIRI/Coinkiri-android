package com.coinkiri.coinkiri.ui.coindetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray600
import com.coinkiri.coinkiri.core.designsystem.theme.White

@Composable
fun NavigateToCoinTalkButton() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = White,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_main_talk),
                contentDescription = "",
                modifier = Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = "코인톡 참여하기",
                fontWeight = FontWeight.SemiBold,
                color = Gray600,
                style = CoinkiriTheme.typography.titleMedium
            )
        }
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = ""
        )
    }
}

@Preview
@Composable
fun NavigateToCoinTalkButtonPreview() {
    CoinkiriTheme {
        NavigateToCoinTalkButton()
    }
}
