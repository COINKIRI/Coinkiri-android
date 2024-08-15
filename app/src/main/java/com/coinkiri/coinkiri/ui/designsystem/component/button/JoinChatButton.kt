package com.coinkiri.coinkiri.ui.designsystem.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.SemiBlue

@Composable
fun JoinChatButton(
    onClick: () -> Unit,
    buttonIcon: ImageVector,
    buttonText: String
) {
    OutlinedButton(
        onClick = onClick,
        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 10.dp),
        modifier = Modifier.height(30.dp)
    ) {
        Icon(
            imageVector = buttonIcon,
            contentDescription = "JoinChatButton",
            tint = SemiBlue,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = buttonText,
            color = SemiBlue,
            style = CoinkiriTheme.typography.labelSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JoinChatButtonPreview() {
    CoinkiriTheme {
        JoinChatButton(
            onClick = {},
            buttonIcon = Icons.Default.FavoriteBorder,
            buttonText = "코인톡참여"
        )
    }
}
