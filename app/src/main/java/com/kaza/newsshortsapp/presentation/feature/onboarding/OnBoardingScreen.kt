package com.kaza.newsshortsapp.presentation.feature.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kaza.newsshortsapp.ui.theme.Dimens.MediumPadding2
import com.kaza.newsshortsapp.presentation.components.NewsButton
import com.kaza.newsshortsapp.presentation.components.NewsTextButton
import com.kaza.newsshortsapp.presentation.feature.onboarding.components.OnBoardingPage
import com.kaza.newsshortsapp.presentation.feature.onboarding.components.PagerIndicator
import com.kaza.newsshortsapp.presentation.feature.onboarding.data.OnBoardingEvent
import com.kaza.newsshortsapp.presentation.feature.onboarding.data.pages
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    onEvent:(OnBoardingEvent)->Unit
) {
    Column(modifier = Modifier.fillMaxSize())
    {

        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonsState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PagerIndicator(
                modifier = Modifier.width(52.dp),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()

                if (buttonsState.value[0].isNotEmpty()) {
                    NewsTextButton(
                        text = buttonsState.value[0], onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage - 1
                                )
                            }
                        })
                }

                NewsButton(
                    text = buttonsState.value[1],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                //todo Navigate to the main screen and save a value in datastore preferences
                                onEvent(OnBoardingEvent.SaveAppEntry)
                            } else {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    })


            }

        }
        Spacer(modifier = Modifier.weight(0.5f))

    }
}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(onEvent = {

    })
}