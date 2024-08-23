package com.coinkiri.coinkiri.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.flowWithLifecycle
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.ui.designsystem.theme.Gray500
import com.coinkiri.coinkiri.ui.designsystem.theme.SemiBlue
import com.coinkiri.coinkiri.ui.designsystem.theme.White
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToHome: (Boolean) -> Unit,
    navigateToLogIn: () -> Unit,
    viewModel: SplashViewModel = hiltViewModel(),
) {

    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        viewModel.showSplash()
    }

    LaunchedEffect(viewModel.sideEffects, lifecycleOwner) {
        viewModel.sideEffects.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is SplashSideEffect.NavigateToHome -> navigateToHome(true)
                    is SplashSideEffect.NavigateLogin -> navigateToLogIn()
                }
            }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Spacer(modifier = Modifier.weight(200f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "코인이 처음이면 끼리끼리",
                fontSize = 20.sp,
                color = Gray500,
                style = CoinkiriTheme.typography.yangJinHeadlineSmall
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = stringResource(id = R.string.kr_app_name),
                style = CoinkiriTheme.typography.yangJinHeadlineSmall,
                color = SemiBlue,
                fontSize = 50.sp
            )
            Spacer(modifier = Modifier.height(42.dp))
            Surface(
                shape = RoundedCornerShape(28.dp),
                color = SemiBlue,
                modifier = Modifier.size(150.dp)
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.img_coinkiri_app_icon),
                    contentDescription = "logo",
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(260f))
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    CoinkiriTheme {
        SplashScreen(
            navigateToHome = {},
            navigateToLogIn = {}
        )
    }
}
