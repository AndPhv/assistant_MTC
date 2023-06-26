package com.sogya.mtc.domain.usecase.lesson

import com.sogya.mtc.domain.repository.LessonRepository

class GetAllLessonsUseCase(private val lessonRepository: LessonRepository) {
    operator fun invoke() = lessonRepository.getAllLesson()
}