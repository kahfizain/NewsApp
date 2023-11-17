package com.kaza.newsshortsapp.presentation.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.kaza.newsshortsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVIewModel @Inject constructor(
    private val nesUsesCases : NewsUseCases
): ViewModel() {

    val news = nesUsesCases.getNews(
        sources = listOf("bbc-news","abc-news","jl-jazeera-english")
    ).cachedIn(viewModelScope)
}