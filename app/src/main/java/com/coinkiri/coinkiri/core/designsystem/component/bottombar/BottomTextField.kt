package com.coinkiri.coinkiri.core.designsystem.component.bottombar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.core.designsystem.theme.White

@Composable
fun BottomTextField() {
    BottomAppBar(
        containerColor = SemiBlue,
        contentPadding = PaddingValues(horizontal = 5.dp),
        windowInsets = BottomAppBarDefaults.windowInsets,
    ) {
        TextField(
            value = "안녕하세요",
            onValueChange = { },
            trailingIcon = {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(35.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_circle_up),
                        contentDescription = "전송",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(35.dp),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun PreviewBottomTextField() {
    CoinkiriTheme {
        BottomTextField(

        )
    }
}
