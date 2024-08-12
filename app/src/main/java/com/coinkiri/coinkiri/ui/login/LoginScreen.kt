package com.coinkiri.coinkiri.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.theme.Black
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.Kakao
import com.coinkiri.coinkiri.ui.designsystem.theme.Naver
import com.coinkiri.coinkiri.ui.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.ui.designsystem.theme.White
import com.coinkiri.coinkiri.ui.login.component.LoginBtn

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SemiBlue)
    ) {
        LoginScreenContent()
    }
}

@Composable
private fun LoginScreenContent() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp, vertical = 40.dp)
    ) {
        Text(
            text = stringResource(id = R.string.kr_app_name),
            color = White,
            fontSize = 60.sp,
            textAlign = TextAlign.Center,
            style = CoinkiriTheme.typography.yangJinHeadlineSmall,
            modifier = Modifier
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.img_coinkiri_app_icon),
            contentDescription = "app icon"
        )
        LoginBtnSection(
            onKakaoBtnClick = { /*TODO 카카오 로그인 구현하기*/ },
            onNaverBtnClick = { /*TODO 네이버 로그인 구현하기*/ }
        )
    }
}

@Composable
private fun LoginBtnSection(
    onKakaoBtnClick: () -> Unit,
    onNaverBtnClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        LoginBtn(
            onLoginBtnClick = onKakaoBtnClick,
            text = R.string.kakao_login,
            image = R.drawable.img_login_kakao,
            btnColor = Kakao,
            textColor = Black
        )

        LoginBtn(
            onLoginBtnClick = onNaverBtnClick,
            text = R.string.naver_login,
            image = R.drawable.img_login_naver,
            btnColor = Naver,
            textColor = White
        )
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    CoinkiriTheme {
        LoginScreen()
    }
}
