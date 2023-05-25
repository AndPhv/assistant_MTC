package com.example.assistant_mtc.screen.lesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assistant_mtc.model.LessonPresentation
import com.sogya.mtc.domain.models.LessonDomain

class LessonVM: ViewModel() {
    private val lessonList = arrayListOf(
        LessonPresentation("1", "Лекция в аудитории 101","Тактика ВВС", "Непорожнев Д.А.","Тактика военно-воздушных сил — составная часть военного искусства ВВС, включающая теорию и практику подготовки и ведения боя авиационным соединением, частью, подразделением, одиночным самолётом (вертолётом). ")
    )

    private val lessonLiveData = MutableLiveData<List<LessonDomain>>()

    fun getLessonLiveData(): LiveData<List<LessonDomain>> = lessonLiveData


    init {
        lessonLiveData.value = lessonList
    }
}