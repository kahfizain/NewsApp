package com.kaza.newsshortsapp.domain.usecases.news

import androidx.paging.PagingData
import com.kaza.newsshortsapp.domain.model.Article
import com.kaza.newsshortsapp.domain.model.Source
import com.kaza.newsshortsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun  invoke(sources: List<String>):Flow<PagingData<Article>>{

        return newsRepository.getNews(sources = sources)
    }
}