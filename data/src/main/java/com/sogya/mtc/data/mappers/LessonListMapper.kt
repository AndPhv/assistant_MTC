package com.sogya.mtc.data.mappers

import com.sogya.mtc.data.models.LessonData
import com.sogya.mtc.domain.models.LessonDomain

class LessonListMapper(
    private val dataList: List<LessonData>
) {
    fun map(): List<LessonDomain>{
        val list = arrayListOf<LessonDomain>()
        dataList.forEach {
            list.add(it.toDomain())
        }
        return list
    }
}