package com.example.assistant_mtc.screen.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assistant_mtc.mapper.toPresentationList
import com.example.assistant_mtc.model.LessonPresentation
import com.sogya.mtc.domain.usecase.lesson.GetAllLessonsUseCase
import com.sogya.mtc.domain.usecase.lesson.InsertLessonsUseCase
import com.sogya.mtc.domain.usecase.network.GetLessonsByGroupIdUseCase
import com.sogya.mtc.domain.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    getLessonsUseCase: GetAllLessonsUseCase,
    private val insertLessonsUseCase: InsertLessonsUseCase,
    private val getLessonsByGroupIdUseCase: GetLessonsByGroupIdUseCase
) : ViewModel() {
    private var lessonLiveData = MutableLiveData<List<LessonPresentation>>()
    private val groupId: Int? = null
    private val errorLiveData = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            getLessonsUseCase().flowOn(Dispatchers.IO).catch {
                Log.e("LessonFlowError", it.message.toString())
            }.map { lessonListDomain ->
                lessonListDomain.toPresentationList()
            }.collect { lessonList ->
                lessonLiveData.postValue(lessonList)
            }
        }
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

    fun getHomeLiveData(): LiveData<List<LessonPresentation>> = lessonLiveData
    fun getErrorLiveData(): LiveData<String> = errorLiveData
}