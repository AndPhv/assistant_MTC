package com.sogya.mtc.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sogya.mtc.data.models.LessonData

@Database(
    entities = [LessonData::class], version = 1
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun lessonDao(): LessonDao
}