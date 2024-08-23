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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.flowWithLifecycle
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.theme.Black
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.Kakao
import com.coinkiri.coinkiri.ui.designsystem.theme.Naver
import com.coinkiri.coinkiri.ui.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.ui.designsystem.theme.White
import com.coinkiri.coinkiri.ui.login.component.LoginBtn
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginRoute(
    navigateToHome: () -> Unit,
) {
    val viewModel: LoginViewModel = hiltViewModel()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(viewModel.loginSideEffects, lifecycleOwner) {
        viewModel.loginSideEffects
            .flowWithLifecycle(lifecycleOwner.lifecycle)
            .collectLatest { sideEffect ->
                when (sideEffect) {
                    is LoginSideEffect.LoginSuccess -> {
                        navigateToHome()
                    }

                    is LoginSideEffect.LoginError -> {
                        /* TODO : LoginError 필요시 추가 동작 */
                    }
                }
            }
    }

    LoginScreen(
        onKakaoBtnClick = { viewModel.startKakaoTalkLogin() },
        onNaverBtnClick = { /*TODO : naver 로그인 추가*/ }
    )
}

@Composable
fun LoginScreen(
    onKakaoBtnClick: () -> Unit,
    onNaverBtnClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SemiBlue)
    ) {
        LoginScreenContent(
            onNaverBtnClick = onNaverBtnClick,
            onKakaoBtnClick = onKakaoBtnClick
        )
    }
}

@Composable
private fun LoginScreenContent(
    onKakaoBtnClick: () -> Unit,
    onNaverBtnClick: () -> Unit,
) {
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
}

@Preview
@Composable
private fun LoginScreenPreview() {
    CoinkiriTheme {
        LoginScreen(
            onKakaoBtnClick = {},
            onNaverBtnClick = {}
        )
    }
}
