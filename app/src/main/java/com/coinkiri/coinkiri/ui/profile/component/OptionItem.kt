package com.coinkiri.coinkiri.ui.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme

@Composable
fun OptionItem(
    text: String,
    onOptionClick: () -> Unit
) {
    Surface(
        onClick = onOptionClick,
        color = Color.Transparent,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            Text(
                text = text,
                color = Black,
                fontWeight = FontWeight.Thin,
                style = CoinkiriTheme.typography.titleMedium
            )
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OptionItemtPreview() {
    CoinkiriTheme {
        OptionItem(
            text = "테마변경",
            onOptionClick = {}
        )
    }
}
