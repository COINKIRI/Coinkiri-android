package com.coinkiri.coinkiri.ui.talkdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.ui.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.ui.designsystem.theme.White


@Composable
fun ChatContent(paddingValues: PaddingValues) {
    var messages by remember {// 이 변수 값이 변경되면 자동으로 ui를 다시 그리게 함.
        mutableStateOf(listOf<String>())//초기값은 빈 문자열 리스트
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(paddingValues)
    ) {
        SelectedCoinInfo()
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(messages) { message ->
                TextBubble(message)
            }
        }
        ChatInputField(messages = messages) { newMessage ->
            messages = messages + newMessage // 새 메시지를 추가
        }
    }
}

/*TODO 말풍선*/
@Composable
fun TextBubble(message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = message,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .fillMaxHeight()
                .background(SemiBlue)
                .padding(horizontal = 10.dp)
                .wrapContentHeight(Alignment.CenterVertically),
            color = White
        )
    }
}
