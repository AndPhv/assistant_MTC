package com.sogya.mtc.data.repository

import com.sogya.mtc.data.network.api.NetworkApi
import com.sogya.mtc.domain.models.LessonDomain
import com.sogya.mtc.domain.repository.NetworkRepository
import com.sogya.mtc.domain.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkRepositoryImpl : NetworkRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URI)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NetworkApi::class.java)

    override suspend fun getLessonsByGroupId(
        token: String,
        groupId: Int
    ): Flow<List<LessonDomain>> = flow {
        emit(retrofit.getLessonsByGroupIdAsync(token, groupId))
    }
}