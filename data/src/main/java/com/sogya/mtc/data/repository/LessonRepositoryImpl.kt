package com.sogya.mtc.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
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

    override suspend fun insert(lesson: LessonDomain) {
        db.lessonDao().insert(LessonData().toData(lesson))
    }

    override fun getAllLesson(): LiveData<List<LessonDomain>> {
        return Transformations.map(db.lessonDao().getAllLesson()) {
            LessonListMapper(it).map()
        }
    }
}