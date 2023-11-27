package com.kaza.newsshortsapp.presentation.feature.search.data

sealed class SearchEvent  {

    data class UpdateSearchQuery(val  searchQuery : String): SearchEvent()
    object Search : SearchEvent()
}