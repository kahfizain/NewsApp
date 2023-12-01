package com.kaza.newsshortsapp.presentation.feature.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.kaza.newsshortsapp.R
import com.kaza.newsshortsapp.domain.model.Article
import com.kaza.newsshortsapp.presentation.components.ArticlesList
import com.kaza.newsshortsapp.presentation.feature.bookmark.data.BookmarkViewModel
import com.kaza.newsshortsapp.ui.theme.Dimens.MediumPadding1

@Composable
fun BookmarkScreen(
    viewModel: BookmarkViewModel = hiltViewModel(),
    navigateToDetail: (Article) -> Unit

) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
    ) {

        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

       ArticlesList(
           articles = viewModel.state.value.articles,
           onClick = navigateToDetail )


    }
}