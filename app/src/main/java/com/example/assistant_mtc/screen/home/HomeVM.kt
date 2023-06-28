package com.example.assistant_mtc.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sogya.mtc.domain.models.LessonDomain
import com.sogya.mtc.domain.usecase.lesson.GetAllLessonsUseCase
import com.sogya.mtc.domain.usecase.lesson.InsertLessonsUseCase
import com.sogya.mtc.domain.usecase.network.GetLessonsByGroupIdUseCase
import com.sogya.mtc.domain.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    getLessonsUseCase: GetAllLessonsUseCase,
    private val insertLessonsUseCase: InsertLessonsUseCase,
    private val getLessonsByGroupIdUseCase: GetLessonsByGroupIdUseCase
) : ViewModel() {
    private var lessonLiveData: LiveData<List<LessonDomain>> = MutableLiveData()
    private val groupId: Int? = null
    private val errorLiveData = MutableLiveData<String>()

    fun getHomeLiveData(): LiveData<List<LessonDomain>> = lessonLiveData
    fun getErrorLiveData(): LiveData<String> = errorLiveData

    init {
        lessonLiveData = getLessonsUseCase()
        //updateTimeTable()
    }

    private fun updateTimeTable() {
        viewModelScope.launch {
            getLessonsByGroupIdUseCase(token = Constants.BASE_TOKEN, groupId = groupId!!)
                .flowOn(Dispatchers.IO)
                .catch {
                    errorLiveData.postValue(it.message)
                }
                .collect {
                    insertLessonsUseCase.invoke(it)
                }
        }
    }
}