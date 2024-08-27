package com.coinkiri.coinkiri.ui.profile.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.White

@Composable
fun ProfileImg() {
    Card(
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(White),
        border = BorderStroke(color = Color(0xFFB0B0B0), width = 2.dp),
        modifier = Modifier
            .size(130.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_coinkiri_app_icon_dark),
            contentDescription = "defaultImg"
        )
    }
}

@Preview
@Composable
fun ProfileImgPreview() {
    ProfileImg()
}
