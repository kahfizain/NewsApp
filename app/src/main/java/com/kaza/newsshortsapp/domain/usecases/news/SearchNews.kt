package com.kaza.newsshortsapp.domain.usecases.news

import androidx.paging.PagingData
import com.kaza.newsshortsapp.domain.model.Article
import com.kaza.newsshortsapp.domain.repository.NewsRepository

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): kotlinx.coroutines.flow.Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}