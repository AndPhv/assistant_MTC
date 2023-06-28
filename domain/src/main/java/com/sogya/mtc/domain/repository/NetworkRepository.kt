package com.sogya.mtc.domain.repository


import com.sogya.mtc.domain.models.LessonDomain
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {
    suspend fun getLessonsByGroupId(token: String, groupId: Int): Flow<List<LessonDomain>>
}