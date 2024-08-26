package com.coinkiri.coinkiri.ui.talkdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.core.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.core.designsystem.theme.White


@Composable
fun ChatInputField(messages: List<String>, onMessageSent: (String) -> Unit) {

    var text by remember {
        mutableStateOf("")
    }

    BottomAppBar(
        containerColor = SemiBlue,
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp))
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(White)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = White,
                    unfocusedContainerColor = White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .weight(1f),
            )
            IconButton(onClick = {
                if (text.isNotEmpty()) {//텍스트에 입력을 했을 때
                    onMessageSent(text) //람다형식으로 전달
                    text = "" //전송후 텍스트 필트 초기화 시킴
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowCircleUp,
                    contentDescription = "전송",
                )
            }
        }
    }
}
