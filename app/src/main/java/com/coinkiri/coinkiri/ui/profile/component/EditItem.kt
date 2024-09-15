package com.coinkiri.coinkiri.ui.profile.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.Gray300
import com.coinkiri.coinkiri.core.designsystem.theme.White
import com.coinkiri.coinkiri.ui.profile.model.UserInfoModel

@Composable
fun EditItem(
    userInfo: UserInfoModel,
) {

    var text by remember {
        mutableStateOf(userInfo.nickname)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(30.dp)
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
        ) {
            Card(
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(White),
                border = BorderStroke(
                    color = Gray300,
                    width = 1.dp
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.img_coinkiri_app_icon_dark),
                    contentDescription = "default img"
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(White)
                    .border(
                        BorderStroke(1.dp, Color.LightGray),
                        shape = RoundedCornerShape(50.dp)
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = "이미지 수정버튼",
                    tint = Color.LightGray
                )
            }
        }
        Spacer(modifier = Modifier.padding(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(White)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "사용자 이름",
                modifier = Modifier
                    .weight(0.4f)
            )
            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.LightGray,
                    focusedIndicatorColor = Black,
                    unfocusedContainerColor = White,
                    focusedContainerColor = White
                ),
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Preview
@Composable
fun EditItemPreview() {
    EditItem(
        userInfo = UserInfoModel()
    )
}
