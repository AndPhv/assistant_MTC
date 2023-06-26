package com.sogya.mtc.data.repository

import com.sogya.mtc.data.mappers.LessonListMapper
import com.sogya.mtc.data.network.api.NetworkApi
import com.sogya.mtc.domain.models.LessonDomain
import com.sogya.mtc.domain.repository.NetworkRepository
import com.sogya.mtc.domain.utils.Constants
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkRepositoryImpl : NetworkRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URI)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NetworkApi::class.java)

    override fun getLessonsByGroupId(token: String, groupId: Int): Single<List<LessonDomain>> {
        return retrofit.getLessonsByGroupId(token, groupId).map {
            LessonListMapper(it).mapToDomainList()
        }
    }
}