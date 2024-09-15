package com.coinkiri.coinkiri.ui.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.coinkiri.coinkiri.ui.profile.model.UserInfoModel

@Composable
fun UserInfoItem(
    userInfo: UserInfoModel
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Image(
//                painter = byteArrayToPainter(userInfo.pic),
            painter = painterResource(id = R.drawable.img_coinkiri_app_icon_dark),
            contentDescription = "default img",
            modifier = Modifier
                .size(150.dp)
                .background(
                    color = White,
                    shape = RoundedCornerShape(50.dp)
                )
                .border(
                    width = 1.dp,
                    color = Gray300,
                    shape = RoundedCornerShape(50.dp)
                )
        )
        Spacer(modifier = Modifier.padding(12.dp))
        Text(
            text = userInfo.nickname,
            style = CoinkiriTheme.typography.headlineSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun UserInfoItemPreview() {
    CoinkiriTheme {
        UserInfoItem(
            UserInfoModel(
                nickname = "userName"
            )
        )
    }
}
