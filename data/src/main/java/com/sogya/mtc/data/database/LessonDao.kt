package com.sogya.mtc.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sogya.mtc.data.models.LessonData
import com.sogya.mtc.domain.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface LessonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLessons(lessonList: List<LessonData>)

    @Delete
    suspend fun deleteLessons(lessonList: List<LessonData>)

    @Update
    suspend fun updateLesson(lesson: LessonData)

    @Query("SELECT * FROM ${Constants.LESSON_TABLE_NAME} WHERE id IN (:lessonId)")
    fun getLessonById(lessonId: String): Flow<LessonData>

    @Query("SELECT * FROM ${Constants.LESSON_TABLE_NAME}")
    fun getAllLesson(): Flow<List<LessonData>>
}