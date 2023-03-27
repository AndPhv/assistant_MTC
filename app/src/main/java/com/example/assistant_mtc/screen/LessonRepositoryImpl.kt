package com.example.assistant_mtc.screen

import com.sogya.mtc.domain.models.LessonDomain

class LessonRepositoryImpl(private val lessonDao: LessonDao) : LessonRepository {
    override suspend fun insert(lesson: LessonDomain) {
        lessonDao.insert(lesson)
    }

    override suspend fun getAllLesson() = lessonDao.getAllLesson()
}