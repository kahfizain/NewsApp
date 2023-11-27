package com.kaza.newsshortsapp.presentation.feature.dashboard

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kaza.newsshortsapp.domain.model.Article
import com.kaza.newsshortsapp.presentation.feature.dashboard.components.DashboardBottomNavigation
import com.kaza.newsshortsapp.presentation.feature.dashboard.data.menuDashboard
import com.kaza.newsshortsapp.presentation.feature.dashboard.data.navigateToTab
import com.kaza.newsshortsapp.presentation.feature.details.DetailsScreen
import com.kaza.newsshortsapp.presentation.feature.home.HomeScreen
import com.kaza.newsshortsapp.presentation.feature.search.SearchScreen
import com.kaza.newsshortsapp.presentation.nvgraph.Route

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard() {

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.SearchScreen.route -> 1
        Route.BookmarkScreen.route -> 2
        else -> 0
    }

    //Hide the bottom navigation when the user is in the details screen
    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Route.HomeScreen.route ||
                backStackState?.destination?.route == Route.SearchScreen.route ||
                backStackState?.destination?.route == Route.BookmarkScreen.route
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible){
                DashboardBottomNavigation(
                    items = menuDashboard,
                    selectedItem = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTab(
                                navController = navController,
                                route = Route.HomeScreen.route
                            )

                            1 -> navigateToTab(
                                navController = navController,
                                route = Route.SearchScreen.route
                            )

                            2 -> navigateToTab(
                                navController = navController,
                                route = Route.BookmarkScreen.route
                            )
                        }
                    })
            }

        }
    ) {
        val bottomPadding = it.calculateBottomPadding()

        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                HomeScreen(
                    navigateToSearch = {
                        navigateToTab(
                            navController = navController,
                            route = it
                        )
                    },
                    navigateToDetails ={article->
                        navigateToDetails(
                            navController=navController,
                            article = article)

                    })
            }

            composable(route = Route.SearchScreen.route) {
                OnBackClickStateSaver(navController = navController)
                SearchScreen(navigateToDetails = { article ->
                    navigateToDetails(
                        navController = navController,
                        article = article
                    )
                })
            }

            composable(route = Route.DetailsScreen.route) {
                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")
                    ?.let { article ->
                        DetailsScreen(
                            article = article,
                            event = {},
                            navigateUp = {
                                navController.navigateUp()
                            })
                    }
            }

            composable(route = Route.BookmarkScreen.route) {

            }


        }
    }
}
private fun navigateToDetails(navController: NavController, article: Article){
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(
        route = Route.DetailsScreen.route
    )
}


@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Route.HomeScreen.route
        )
    }
}