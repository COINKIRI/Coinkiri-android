package com.coinkiri.coinkiri.ui.profile.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray300
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.core.util.byteArrayToPainter
import com.coinkiri.coinkiri.domain.user.entity.UserEntity

@Composable
fun UserInfoItem(
    userInfo: UserEntity?
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Card(
            shape = RoundedCornerShape(50.dp),
            colors = CardDefaults.cardColors(White),
            border = BorderStroke(
                color = Gray300,
                width = 1.dp
            ),
            modifier = Modifier.size(150.dp)
        ) {
            if (userInfo != null) {
                Image(
                    painter = byteArrayToPainter(userInfo.pic),
                    contentDescription = "default img"
                )
            }
        }
        Spacer(modifier = Modifier.padding(12.dp))
        if (userInfo != null) {
            Text(
                text = userInfo.nickname,
                style = CoinkiriTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserInfoItemPreview() {
    CoinkiriTheme {
        UserInfoItem(
            UserEntity(
                pic = "",
                nickname = ""
            )
        )
    }
}
