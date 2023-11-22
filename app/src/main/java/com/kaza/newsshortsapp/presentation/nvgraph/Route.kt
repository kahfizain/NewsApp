package com.kaza.newsshortsapp.presentation.nvgraph

sealed class Route(
    val route : String
){
    object OnBoardingScreen : Route(route = "OnBoardingScreen")
    object HomeScreen : Route(route = "HomeScreen")
    object SearchScreen : Route(route = "SearchScreen")
    object BookmarkScreen : Route(route = "BookmarkScreen")
    object DetailScreen : Route(route = "DetailScreen")
    object AppStartNavigation : Route(route = "AppStartNavigation")
    object Dashboard : Route(route = "Dashboard")
    object DashboardScreen : Route(route = "DashboardScreen")

}
