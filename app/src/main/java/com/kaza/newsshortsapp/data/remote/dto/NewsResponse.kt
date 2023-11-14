package com.kaza.newsshortsapp.data.remote.dto

import com.kaza.newsshortsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)