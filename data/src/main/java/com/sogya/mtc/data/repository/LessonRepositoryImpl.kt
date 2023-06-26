package com.sogya.mtc.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.room.Room
import com.sogya.mtc.data.database.AppDataBase
import com.sogya.mtc.data.mappers.LessonListMapper
import com.sogya.mtc.data.models.LessonData
import com.sogya.mtc.domain.models.LessonDomain
import com.sogya.mtc.domain.repository.LessonRepository

class LessonRepositoryImpl(context: Context) : LessonRepository {
    private val db = Room.databaseBuilder(
        context, AppDataBase::class.java, "local-data-base"
    ).allowMainThreadQueries()
        .build()
    private val lessonDao = db.lessonDao()

    override suspend fun insertLessons(lessonList: List<LessonDomain>) {
        lessonDao.insertLessons(LessonListMapper(domainList = lessonList).mapToDataList())
    }

    override suspend fun deleteLessons(lessonList: List<LessonDomain>) {
        lessonDao.deleteLessons(LessonListMapper(domainList = lessonList).mapToDataList())
    }

    override fun getAllLesson(): LiveData<List<LessonDomain>> {
        return lessonDao.getAllLesson().map {
            LessonListMapper(it).mapToDomainList()
        }
    }

    override suspend fun updateLesson(lesson: LessonDomain) {
        lessonDao.updateLesson(LessonData().toData(lesson))
    }

    override fun getLessonById(lessonId: String): LiveData<LessonDomain> {
        return lessonDao.getLessonById(lessonId).map {
            it
        }
    }
}