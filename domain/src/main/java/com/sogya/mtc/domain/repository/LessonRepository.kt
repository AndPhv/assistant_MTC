package com.sogya.mtc.domain.repository

import androidx.lifecycle.LiveData
import com.sogya.mtc.domain.models.LessonDomain

interface LessonRepository {
    suspend fun insert(lesson: LessonDomain)
    fun getAllLesson(): LiveData<List<LessonDomain>>
}