package com.kaza.newsshortsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.kaza.newsshortsapp.presentation.onboarding.OnBoardingScreen
import com.kaza.newsshortsapp.ui.theme.NewsShortsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            NewsShortsAppTheme(
                dynamicColor = false
            ) {
                // A surface container using the 'background' color from the theme
               Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)){
                   OnBoardingScreen()
               }
            }
        }
    }
}
