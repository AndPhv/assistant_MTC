package com.sogya.mtc.domain.usecase.lesson

import com.sogya.mtc.domain.models.LessonDomain
import com.sogya.mtc.domain.repository.LessonRepository

class InsertLessonsUseCase(private val lessonRepository: LessonRepository) {
    suspend operator fun invoke(lessonList: List<LessonDomain>) =
        lessonRepository.insertLessons(lessonList)
}