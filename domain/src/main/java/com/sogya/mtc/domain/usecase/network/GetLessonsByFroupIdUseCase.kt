package com.sogya.mtc.domain.usecase.network

import com.sogya.mtc.domain.repository.NetworkRepository

class GetLessonsByFroupIdUseCase(private val networkRepository: NetworkRepository) {
    operator fun invoke(token: String, groupId: Int) =
        networkRepository.getLessonsByGroupId(token,groupId)
}