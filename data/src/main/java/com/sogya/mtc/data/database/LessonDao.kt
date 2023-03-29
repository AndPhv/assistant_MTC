package com.sogya.mtc.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sogya.mtc.data.models.LessonData

@Dao
interface LessonDao {
    @Insert
    suspend fun insert(lesson: LessonData)

    @Query("SELECT * FROM lesson")
    fun getAllLesson(): LiveData<List<LessonData>>
}