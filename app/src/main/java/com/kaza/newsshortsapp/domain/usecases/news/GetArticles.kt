package com.kaza.newsshortsapp.domain.usecases.news

import com.kaza.newsshortsapp.data.local.NewsDao
import com.kaza.newsshortsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles (
    private val newsDao: NewsDao
) {

    operator fun invoke():Flow<List<Article>>{
        return newsDao.getArticle()
    }
}