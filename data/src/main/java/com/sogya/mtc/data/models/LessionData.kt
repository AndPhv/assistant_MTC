package com.sogya.mtc.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sogya.mtc.domain.models.LessonDomain

@Entity(tableName = "lesson")
data class LessonData(
    @PrimaryKey
    val id: String = "",
    val audience: String = "",
    val lesson: String = "",
    val employee: String = "",
    val infoLesson: String = ""
) {
    fun toDomain() = LessonDomain(
        this.id,
        this.audience,
        this.lesson, this.employee, this.infoLesson
    )

    fun toData(lessonDomain: LessonDomain) = LessonData(
        lessonDomain.id,
        lessonDomain.audience,
        lessonDomain.lesson, lessonDomain.employee, lessonDomain.infoLesson
    )
}
