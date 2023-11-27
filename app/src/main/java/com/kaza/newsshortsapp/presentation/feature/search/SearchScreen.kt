package com.kaza.newsshortsapp.presentation.feature.search

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.kaza.newsshortsapp.domain.model.Article
import com.kaza.newsshortsapp.presentation.components.ArticlesList
import com.kaza.newsshortsapp.presentation.components.SearchBar
import com.kaza.newsshortsapp.presentation.feature.search.data.SearchEvent
import com.kaza.newsshortsapp.presentation.feature.search.data.SearchViewModel
import com.kaza.newsshortsapp.ui.theme.Dimens.MediumPadding1

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navigateToDetails:(Article) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding1,
                start = MediumPadding1,
                end = MediumPadding1
            )
            .statusBarsPadding()
    ) {

        SearchBar(
            text = viewModel.state.value.searchQuery,
            readOnly = false,
            onValueChange = {
                viewModel.onEvent(SearchEvent.UpdateSearchQuery(it))
            },
            onSearch = {
                viewModel.onEvent(SearchEvent.Search)
            })
        Spacer(modifier = Modifier.height(MediumPadding1))

        viewModel.state.value.articles?.let {
            val article = it.collectAsLazyPagingItems()
            ArticlesList(
                article = article,
                onClick = navigateToDetails)
        }


    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SearchScreenView() {
    SearchScreen(navigateToDetails = {})
}