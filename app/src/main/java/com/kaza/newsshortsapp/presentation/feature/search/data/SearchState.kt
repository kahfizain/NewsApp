package com.kaza.newsshortsapp.presentation.feature.search.data

import androidx.paging.PagingData
import com.kaza.newsshortsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery : String = "",
    val articles: Flow<PagingData<Article>>? =null
)