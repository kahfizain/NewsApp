package com.kaza.newsshortsapp.di

import android.app.Application
import com.kaza.newsshortsapp.data.manger.LocalUserMangerImpl
import com.kaza.newsshortsapp.domain.manger.LocalUserManger
import com.kaza.newsshortsapp.domain.usecases.app_entry.AppEntryUseCases
import com.kaza.newsshortsapp.domain.usecases.app_entry.ReadAppEntry
import com.kaza.newsshortsapp.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

    )= AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}