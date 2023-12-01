package com.kaza.newsshortsapp.domain.usecases.news

import com.kaza.newsshortsapp.data.local.NewsDao
import com.kaza.newsshortsapp.domain.model.Article

class UpdateInsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.updateInset(article = article)
    }
}