package com.kaza.newsshortsapp.domain.repository

import androidx.paging.PagingData
import com.kaza.newsshortsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>
    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>


}