package com.kaza.newsshortsapp.presentation.feature.details.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaza.newsshortsapp.domain.model.Article
import com.kaza.newsshortsapp.domain.usecases.news.NewsUseCases
import com.kaza.newsshortsapp.util.UIComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
):ViewModel() {


    var sideEffect by mutableStateOf<UIComponent?>(null)
        private set

    fun onEvent(event: DetailsEvent){
        when(event){
            is DetailsEvent.UpdateDeleteArticle->{
                viewModelScope.launch {
                    var article = newsUseCases.getArticleUrl(url = event.article.url)
                    if (article == null){
                        upsertArticle(article = event.article)
                    }else{
                        deleteArticle(article = event.article)
                    }
                }
            }

            is DetailsEvent.RemoveSideEffect->{
                sideEffect =null
            }
        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteArticle(article = article)
        sideEffect = UIComponent.Toast("Article deleted")
    }

    private suspend fun upsertArticle(article: Article) {
        newsUseCases.updateInsertArticle(article = article)
        sideEffect = UIComponent.Toast("Article Inserted")
    }
}