package com.kaza.newsshortsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.kaza.newsshortsapp.domain.usecases.AppEntryUseCases
import com.kaza.newsshortsapp.presentation.mainActivity.MainViewModel
import com.kaza.newsshortsapp.presentation.nvgraph.NavGraph
import com.kaza.newsshortsapp.presentation.onboarding.OnBoardingScreen
import com.kaza.newsshortsapp.presentation.onboarding.OnBoardingViewModel
import com.kaza.newsshortsapp.ui.theme.NewsShortsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


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
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    NavGraph(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}
