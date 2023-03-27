package com.example.assistant_mtc.screen

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sogya.mtc.domain.models.LessonDomain

@Database(
    entities = [LessonDomain::class], version = 1
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun lessonDao(): LessonDao

    companion object {
        fun buildDatabase(context: Context, dbName: String): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, dbName).build()
        }
    }
}