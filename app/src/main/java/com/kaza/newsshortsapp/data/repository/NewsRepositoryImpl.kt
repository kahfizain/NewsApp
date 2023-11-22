package com.kaza.newsshortsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kaza.newsshortsapp.data.remote.NewsApi
import com.kaza.newsshortsapp.data.remote.NewsPagingSource
import com.kaza.newsshortsapp.data.remote.SearchNewsPagingSource
import com.kaza.newsshortsapp.domain.model.Article
import com.kaza.newsshortsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    private val pagingConfig = PagingConfig(pageSize = 10)

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { NewsPagingSource(newsApi, sources.joinToString(separator = ",")) }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { SearchNewsPagingSource(newsApi, searchQuery, sources.joinToString(separator = ",")) }
        ).flow
    }
}
