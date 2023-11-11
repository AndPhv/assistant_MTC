package com.sogya.mtc.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sogya.mtc.domain.models.LessonDomain
import com.sogya.mtc.domain.utils.Constants

@Entity(tableName = Constants.LESSON_TABLE_NAME)
data class LessonData(
    @PrimaryKey
    override val id: String = "",
    override val audience: String = "",
    override val lesson: String = "",
    override val employee: String = "",
    override val infoLesson: String = ""
) : LessonDomain
