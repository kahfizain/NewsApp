package com.kaza.newsshortsapp.presentation.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kaza.newsshortsapp.presentation.nvgraph.NavGraph
import com.kaza.newsshortsapp.ui.theme.NewsShortsAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = {
                viewModel.splashCondition.value
            })
        }

        setContent {
            NewsShortsAppTheme(
                dynamicColor = false
            ) {
                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemUiColor = rememberSystemUiController()
                SideEffect {
                    systemUiColor.setStatusBarColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}
