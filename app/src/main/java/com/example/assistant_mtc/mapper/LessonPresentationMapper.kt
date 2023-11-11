package com.example.assistant_mtc.mapper

import com.example.assistant_mtc.model.LessonPresentation
import com.sogya.mtc.domain.models.LessonDomain

fun LessonDomain.toPresentation(): LessonPresentation = LessonPresentation(
    id = id,
    audience = audience,
    lesson = lesson,
    employee = employee,
    infoLesson = infoLesson
)

fun List<LessonDomain>.toPresentationList(): List<LessonPresentation> = map { lessonDomain ->
    lessonDomain.toPresentation()
}