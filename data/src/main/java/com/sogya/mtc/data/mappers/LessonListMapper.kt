package com.sogya.mtc.data.mappers

import com.sogya.mtc.data.models.LessonData
import com.sogya.mtc.domain.models.LessonDomain

class LessonListMapper(
    private val dataList: List<LessonData>? = null,
    private val domainList: List<LessonDomain>? = null
) {
    fun mapToDomainList(): List<LessonDomain> {
        val domainList = arrayListOf<LessonDomain>()
        dataList?.forEach {
            domainList.add(it)
        }
        return domainList
    }

    fun mapToDataList(): List<LessonData> {
        val dataList = arrayListOf<LessonData>()
        domainList?.forEach {
            dataList.add(LessonData().toData(it))
        }
        return dataList
    }
}