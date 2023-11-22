package com.kaza.newsshortsapp.di

import android.app.Application
import com.kaza.newsshortsapp.data.manger.LocalUserMangerImpl
import com.kaza.newsshortsapp.data.remote.NewsApi
import com.kaza.newsshortsapp.data.repository.NewsRepositoryImpl
import com.kaza.newsshortsapp.domain.manger.LocalUserManger
import com.kaza.newsshortsapp.domain.repository.NewsRepository
import com.kaza.newsshortsapp.domain.usecases.app_entry.AppEntryUseCases
import com.kaza.newsshortsapp.domain.usecases.app_entry.ReadAppEntry
import com.kaza.newsshortsapp.domain.usecases.app_entry.SaveAppEntry
import com.kaza.newsshortsapp.domain.usecases.news.GetNews
import com.kaza.newsshortsapp.domain.usecases.news.NewsUseCases
import com.kaza.newsshortsapp.domain.usecases.news.SearchNews
import com.kaza.newsshortsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger

    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}