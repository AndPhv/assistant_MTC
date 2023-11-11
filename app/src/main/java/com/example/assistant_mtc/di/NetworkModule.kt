package com.example.assistant_mtc.di

import com.sogya.mtc.domain.repository.NetworkRepository
import com.sogya.mtc.domain.usecase.network.GetLessonsByGroupIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class NetworkModule {
    @Provides
    fun provideGetLessonByGroupdIdUseCase(networkRepository: NetworkRepository) =
        GetLessonsByGroupIdUseCase(networkRepository)
}