package com.sogya.mtc.data.repository

import android.content.Context
import androidx.room.Room
import com.sogya.mtc.data.database.AppDataBase
import com.sogya.mtc.data.mappers.toData
import com.sogya.mtc.data.mappers.toDataList
import com.sogya.mtc.domain.models.LessonDomain
import com.sogya.mtc.domain.repository.LessonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LessonRepositoryImpl(context: Context) : LessonRepository {
    private val db = Room.databaseBuilder(
        context, AppDataBase::class.java, "local-data-base"
    ).build()

    private val lessonDao = db.lessonDao()

    override suspend fun insertLessons(lessonList: List<LessonDomain>) {
        lessonDao.insertLessons(lessonList = lessonList.toDataList())
    }

    override suspend fun deleteLessons(lessonList: List<LessonDomain>) {
        lessonDao.deleteLessons(lessonList = lessonList.toDataList())
    }

    override fun getAllLesson(): Flow<List<LessonDomain>> {
        return lessonDao.getAllLesson().map { lessonListData ->
            lessonListData
        }
    }

    override suspend fun updateLesson(lesson: LessonDomain) {
        lessonDao.updateLesson(lesson = lesson.toData())
    }

    override fun getLessonById(lessonId: String): Flow<LessonDomain> {
        return lessonDao.getLessonById(lessonId).map { lessonData ->
            lessonData
        }
    }
}