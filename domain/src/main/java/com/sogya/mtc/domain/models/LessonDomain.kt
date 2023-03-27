package com.sogya.mtc.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sogya.mtc.domain.models.LessonDomain.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME
)

data class LessonDomain(
    @PrimaryKey
    val id: String,
    val audience: String,
    val lesson: String,
    val employee: String,
    val infoLesson: String
) {
    companion object {
        const val TABLE_NAME = "LessonInfo"
        const val ID = "Id"
        const val AUDIENCE = "Audience"
        const val LESSON = "Lesson"
        const val EMPLOYEE = "Employee"
        const val INFOLESSON = "InfoLesson"
    }
}
