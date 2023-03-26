package com.example.assistant_mtc.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.mtc.domain.models.HomeDomain

class HomeVM: ViewModel() {
    private val homeList = arrayListOf(
        HomeDomain("1 пара", "09:00 - 10:30", "Самостоятельная работа", "Шубин А.В.", "Ауд. 101"),
        HomeDomain("2 пара", "10:40 - 12:10", "Тактика ВВС", "Непорожнев Д.А.", "Ауд. 101"),
        HomeDomain("3 пара", "13:00 - 14:30", "Военно-специальная подготовка", "Ренкавик В.А.", "Ауд. 101")

    )

    private val homeLiveData = MutableLiveData<List<HomeDomain>>()

    fun getHomeLiveData(): LiveData<List<HomeDomain>> = homeLiveData

    init {
        homeLiveData.value = homeList
    }
}