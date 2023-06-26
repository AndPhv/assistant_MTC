package com.example.assistant_mtc.model

import com.sogya.mtc.domain.models.LessonDomain

data class LessonPresentation(
    override val id: String,
    override val audience: String,
    override val lesson: String,
    override val employee: String,
    override val infoLesson: String
) : LessonDomain