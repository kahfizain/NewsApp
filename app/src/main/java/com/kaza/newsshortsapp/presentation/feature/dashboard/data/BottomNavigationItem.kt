package com.kaza.newsshortsapp.presentation.feature.dashboard.data

import androidx.annotation.DrawableRes

import com.kaza.newsshortsapp.R

data class BottomNavigationItem(
    @DrawableRes val icon : Int,
    val text : String
)

val menuDashboard =  listOf(
    BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
    BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
    BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark"),
)