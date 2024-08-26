package com.coinkiri.coinkiri.ui.login.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Kakao
import com.coinkiri.coinkiri.core.designsystem.theme.Naver
import com.coinkiri.coinkiri.core.designsystem.theme.White

@Composable
fun LoginBtn(
    @DrawableRes image: Int,
    @StringRes text: Int,
    btnColor: Color,
    textColor: Color,
    onLoginBtnClick: () -> Unit
) {
    Card(
        onClick = onLoginBtnClick,
        colors = CardDefaults.cardColors(btnColor),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(55.dp)
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = stringResource(text),
                style = CoinkiriTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = textColor,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
    }
}

@Preview
@Composable
private fun KakaoLoginBtnPreview() {
    CoinkiriTheme {
        LoginBtn(
            text = R.string.kakao_login,
            image = R.drawable.img_login_kakao,
            btnColor = Kakao,
            textColor = Black,
            onLoginBtnClick = {}
        )
    }
}

@Preview
@Composable
private fun NaverLoginBtnPreview() {
    CoinkiriTheme {
        LoginBtn(
            text = R.string.naver_login,
            image = R.drawable.img_login_naver,
            btnColor = Naver,
            textColor = White,
            onLoginBtnClick = {}
        )
    }
}
