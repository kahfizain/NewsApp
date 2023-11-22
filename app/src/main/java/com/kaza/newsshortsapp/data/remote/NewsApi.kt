package com.kaza.newsshortsapp.data.remote

import com.kaza.newsshortsapp.data.remote.dto.NewsResponse
import com.kaza.newsshortsapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNew(
        @Query("sources") sources: String,
        @Query("page") page : Int,
        @Query("apiKey") apiKey : String = API_KEY
    ):NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources")sources: String,
        @Query("page")page: Int,
        @Query("apiKey")apiKey: String = API_KEY
    ):NewsResponse
}

