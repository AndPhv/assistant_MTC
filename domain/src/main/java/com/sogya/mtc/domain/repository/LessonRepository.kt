package com.sogya.mtc.domain.repository

import androidx.lifecycle.LiveData
import com.sogya.mtc.domain.models.LessonDomain

interface LessonRepository {
    suspend fun insertLessons(lessonList: List<LessonDomain>)

    suspend fun deleteLessons(lessonList: List<LessonDomain>)

    fun getAllLesson(): LiveData<List<LessonDomain>>

    suspend fun updateLesson(lesson: LessonDomain)

    fun getLessonById(lessonId: String): LiveData<LessonDomain>
}