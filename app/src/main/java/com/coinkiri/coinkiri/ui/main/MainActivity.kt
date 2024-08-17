package com.coinkiri.coinkiri.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.coinkiri.coinkiri.ui.designsystem.theme.CoinkiriTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinkiriTheme {
                val navigator: ScreenNavigator = rememberScreenNavigator()
                MainScreen(navigator)
            }
        }
    }
}
