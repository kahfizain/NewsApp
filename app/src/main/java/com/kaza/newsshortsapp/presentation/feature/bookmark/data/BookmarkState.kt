package com.kaza.newsshortsapp.presentation.feature.bookmark.data

import com.kaza.newsshortsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
