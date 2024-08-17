package com.coinkiri.coinkiri.ui.talkdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.ui.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.ui.designsystem.theme.White

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
