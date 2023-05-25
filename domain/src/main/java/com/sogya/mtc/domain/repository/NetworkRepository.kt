package com.sogya.mtc.domain.repository


import com.sogya.mtc.domain.models.LessonDomain
import io.reactivex.Single

interface NetworkRepository {
    fun getLessonsByGroupId(token:String, groupId: Int): Single<List<LessonDomain>>
}