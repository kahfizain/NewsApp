package com.kaza.newsshortsapp.presentation.feature.dashboard.data

import androidx.navigation.NavController


fun  navigateToTab(
    navController: NavController,
    route: String){

    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let {
            popUpTo(it) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}

