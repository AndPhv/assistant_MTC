package com.sogya.mtc.domain.usecase.lesson

import com.sogya.mtc.domain.repository.LessonRepository

class GetLessonByIdUseCase(private val lessonRepository: LessonRepository) {
    operator fun invoke(lessonId: String) = lessonRepository.getLessonById(lessonId)
}