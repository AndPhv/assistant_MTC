package com.sogya.mtc.domain.usecase.network

import com.sogya.mtc.domain.repository.NetworkRepository

class GetLessonsByGroupIdUseCase(private val networkRepository: NetworkRepository) {
    suspend operator fun invoke(token: String, groupId: Int) =
        networkRepository.getLessonsByGroupId(token, groupId)
}