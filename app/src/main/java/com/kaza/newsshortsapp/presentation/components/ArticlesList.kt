package com.kaza.newsshortsapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.kaza.newsshortsapp.domain.model.Article
import com.kaza.newsshortsapp.ui.theme.Dimens

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    article: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {

}


@Composable
fun handlePagingResult(article: LazyPagingItems<Article>):Boolean{

    val loadState = article.loadState
    val error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else ->null
    }

    return when{
        loadState.refresh is LoadState.Loading->{
            ShimmerEffect()
            false
        }

        error!=null->{
            false
        }
        else->{
            true
        }
    }
}


@Composable
fun ShimmerEffect(){
    Column(
        verticalArrangement =  Arrangement.spacedBy(Dimens.MediumPadding1)
    ) {
        repeat(10){
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = Dimens.MediumPadding1)
            )
        }
    }
}