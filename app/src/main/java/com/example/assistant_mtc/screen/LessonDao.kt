package com.example.assistant_mtc.screen

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sogya.mtc.domain.models.LessonDomain

@Dao
interface LessonDao {
    @Insert
    suspend fun insert(lesson: LessonDomain)

    @Query("SELECT * FROM ${LessonDomain.TABLE_NAME}")
    suspend fun getAllLesson(): List<LessonDomain>
}