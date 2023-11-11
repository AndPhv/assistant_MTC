package com.sogya.mtc.domain.repository

import com.sogya.mtc.domain.models.LessonDomain
import kotlinx.coroutines.flow.Flow


interface LessonRepository {
    suspend fun insertLessons(lessonList: List<LessonDomain>)

    suspend fun deleteLessons(lessonList: List<LessonDomain>)

    fun getAllLesson(): Flow<List<LessonDomain>>

    suspend fun updateLesson(lesson: LessonDomain)

    fun getLessonById(lessonId: String): Flow<LessonDomain>
}