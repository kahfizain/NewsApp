package com.kaza.newsshortsapp.presentation.nvgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import androidx.navigation.compose.rememberNavController
import com.kaza.newsshortsapp.presentation.feature.dashboard.Dashboard
import com.kaza.newsshortsapp.presentation.feature.onboarding.OnBoardingScreen
import com.kaza.newsshortsapp.presentation.feature.onboarding.data.OnBoardingViewModel


@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.Dashboard.route,
            startDestination = Route.DashboardScreen.route
        ) {
            composable(route = Route.DashboardScreen.route) {
                Dashboard()
            }

        }
    }
}