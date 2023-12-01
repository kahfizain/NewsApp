package com.kaza.newsshortsapp.domain.usecases.news


data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val updateInsertArticle: UpdateInsertArticle,
    val deleteArticle: DeleteArticle,
    val getArticles: GetArticles,
    val getArticleUrl: GetArticleUrl

)
