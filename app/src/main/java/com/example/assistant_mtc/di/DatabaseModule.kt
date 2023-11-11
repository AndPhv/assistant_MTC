package com.example.assistant_mtc.di

import com.sogya.mtc.domain.repository.LessonRepository
import com.sogya.mtc.domain.usecase.lesson.DeleteLessonsUseCase
import com.sogya.mtc.domain.usecase.lesson.GetAllLessonsUseCase
import com.sogya.mtc.domain.usecase.lesson.GetLessonByIdUseCase
import com.sogya.mtc.domain.usecase.lesson.InsertLessonsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DatabaseModule {

    @Provides
    fun provideGetAllLessonsUseCase(lessonRepository: LessonRepository) =
        GetAllLessonsUseCase(lessonRepository)

    @Provides
    fun provideDeleteLessonUseCase(lessonRepository: LessonRepository) =
        DeleteLessonsUseCase(lessonRepository)

    @Provides
    fun provideGetLessonByIdUseCase(lessonRepository: LessonRepository) =
        GetLessonByIdUseCase(lessonRepository)

    @Provides
    fun provideInsertLessonsUseCase(lessonRepository: LessonRepository) =
        InsertLessonsUseCase(lessonRepository)
}