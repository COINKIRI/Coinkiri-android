package com.coinkiri.coinkiri.ui.profile.component

import android.graphics.BitmapFactory
import android.util.Log
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray300
import com.coinkiri.coinkiri.core.designsystem.theme.White
import java.util.Base64

@Composable
fun UserInfoItem(nickname: String, pic: String) {
    val imageBytes = Base64.getDecoder().decode(pic)
    val imageBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
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
            Image(
                bitmap = imageBitmap.asImageBitmap(),
                contentDescription = "profile img"
            )
        }
        Spacer(modifier = Modifier.padding(12.dp))
        Text(
            text = nickname,
            style = CoinkiriTheme.typography.headlineSmall
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun UserInfoItemPreview() {
//    CoinkiriTheme {
//        UserInfoItem()
//    }
//}
