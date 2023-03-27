package com.example.assistant_mtc.screen

import com.sogya.mtc.domain.models.LessonDomain

interface LessonRepository {
    fun insert(lesson: LessonDomain)

    fun getAllLesson()
}