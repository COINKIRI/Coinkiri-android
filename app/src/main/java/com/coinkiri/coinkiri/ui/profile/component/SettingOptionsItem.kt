package com.coinkiri.coinkiri.ui.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray100

@Composable
fun SettingOptionsItem(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(
                color = Gray100,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(top = 15.dp, bottom = 5.dp)
            .padding(horizontal = 15.dp),
    ) {
        Text(
            text = title,
            color = Black,
            fontWeight = FontWeight.SemiBold,
            style = CoinkiriTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
        )
        content()
    }
}

@Preview
@Composable
private fun SettingOptionsItemPreview() {
    CoinkiriTheme {
        SettingOptionsItem(
            title = "App 설정"
        ) { }
    }
}
