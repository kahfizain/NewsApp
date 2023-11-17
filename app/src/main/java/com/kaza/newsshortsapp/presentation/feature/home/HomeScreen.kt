package com.kaza.newsshortsapp.presentation.feature.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.kaza.newsshortsapp.R
import com.kaza.newsshortsapp.presentation.components.ArticlesList
import com.kaza.newsshortsapp.presentation.feature.home.data.HomeViewModel
import com.kaza.newsshortsapp.ui.theme.Dimens

@Composable
fun HomeScreen(navigate: (String) -> Unit) {


    val viewModel: HomeViewModel = hiltViewModel()
    val articles = viewModel.news.collectAsLazyPagingItems()

    /*val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }*/
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Dimens.MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_splash),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = Dimens.MediumPadding1))
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))


        ArticlesList(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            article = articles,
            onClick = {
                //TODO: Navigate to Details Screen
            }
        )

    }
}

@Preview
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenView() {
    HomeScreen(navigate = {

    })
}