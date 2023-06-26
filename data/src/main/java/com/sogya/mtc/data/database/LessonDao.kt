package com.sogya.mtc.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sogya.mtc.data.models.LessonData

@Dao
interface LessonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLessons(lessonList: List<LessonData>)

    @Delete
    suspend fun deleteLessons(lessonList: List<LessonData>)

    @Update
    suspend fun updateLesson(lesson: LessonData)

    @Query("SELECT * FROM lesson WHERE id IN (:lessonId)")
    fun getLessonById(lessonId: String): LiveData<LessonData>

    @Query("SELECT * FROM lesson")
    fun getAllLesson(): LiveData<List<LessonData>>
}