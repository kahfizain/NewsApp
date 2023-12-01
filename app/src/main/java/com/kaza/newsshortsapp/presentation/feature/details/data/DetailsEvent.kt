package com.kaza.newsshortsapp.presentation.feature.details.data

import com.kaza.newsshortsapp.domain.model.Article

sealed class DetailsEvent{

    data class UpdateDeleteArticle(val article: Article): DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}