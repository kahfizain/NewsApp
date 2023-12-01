package com.kaza.newsshortsapp.domain.usecases.news

import com.kaza.newsshortsapp.data.local.NewsDao
import com.kaza.newsshortsapp.domain.model.Article

class DeleteArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }
}