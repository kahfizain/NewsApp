package com.kaza.newsshortsapp.domain.usecases.news

import com.kaza.newsshortsapp.data.local.NewsDao
import com.kaza.newsshortsapp.domain.model.Article

class GetArticleUrl (
    private val newsDao: NewsDao
){

    suspend operator fun invoke(url : String):Article?{
        return newsDao.getArticleWhereUrl(url= url)
    }
}