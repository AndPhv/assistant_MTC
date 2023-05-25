package com.sogya.mtc.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sogya.mtc.domain.models.LessonDomain

@Entity(tableName = "lesson")
data class LessonData(
    @PrimaryKey
    override val id: String = "",
    override val audience: String = "",
    override val lesson: String = "",
    override val employee: String = "",
    override val infoLesson: String = ""
) : LessonDomain {

    fun toData(lessonDomain: LessonDomain) = LessonData(
        lessonDomain.id,
        lessonDomain.audience,
        lessonDomain.lesson, lessonDomain.employee, lessonDomain.infoLesson
    )
}
