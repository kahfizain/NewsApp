package com.kaza.newsshortsapp.data.repository

import androidx.compose.animation.core.spring
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kaza.newsshortsapp.data.remote.NewsApi
import com.kaza.newsshortsapp.data.remote.NewsPagingSource
import com.kaza.newsshortsapp.domain.model.Article
import com.kaza.newsshortsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }
}