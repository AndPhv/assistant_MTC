package com.sogya.mtc.data.mappers

import com.sogya.mtc.data.models.LessonData
import com.sogya.mtc.domain.models.LessonDomain

fun LessonDomain.toData():LessonData = LessonData(
    id = id,
    audience = audience,
    lesson = lesson,
    employee = employee,
    infoLesson = infoLesson
)

fun List<LessonDomain>.toDataList():List<LessonData> = map { lessonDomain ->
    lessonDomain.toData()
}