package com.sogya.mtc.data.network.api

import com.sogya.mtc.data.models.LessonData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface NetworkApi {

    @GET("/api/lessons/{groupId}")
    suspend fun getLessonsByGroupIdAsync(
        @Header("Authorization") token: String, @Path("groupId") groupId: Int
    ): List<LessonData>
}