package com.example.assistant_mtc.screen

import com.sogya.mtc.domain.models.LessonDomain

interface LessonRepository {
    suspend fun insert(lesson: LessonDomain)

    suspend fun getAllLesson(): List<LessonDomain>
}