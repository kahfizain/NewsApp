package com.kaza.newsshortsapp.util

sealed class DataState<T>{

    data class Loading<T>(val isLoading: Boolean):DataState<T>()
}



sealed class UIComponent{
    data class Toast(val massage: String): UIComponent()
}