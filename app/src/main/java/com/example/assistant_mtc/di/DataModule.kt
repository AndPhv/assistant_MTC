package com.example.assistant_mtc.di

import android.content.Context
import com.sogya.mtc.data.repository.LessonRepositoryImpl
import com.sogya.mtc.data.repository.NetworkRepositoryImpl
import com.sogya.mtc.domain.repository.LessonRepository
import com.sogya.mtc.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 class DataModule {

    @Provides
    @Singleton
    fun provideLessonRepository(@ApplicationContext context: Context): LessonRepository =
        LessonRepositoryImpl(context)

    @Provides
    @Singleton
    fun provideNetworkRepository(): NetworkRepository = NetworkRepositoryImpl()
}