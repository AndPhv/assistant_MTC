package com.example.assistant_mtc.screen.lesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sogya.mtc.domain.models.LessonDomain
import com.sogya.mtc.domain.usecase.lesson.GetLessonByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonVM @Inject constructor(getLessonByIdUseCase: GetLessonByIdUseCase) : ViewModel() {
    private val lessonLiveData = MutableLiveData<List<LessonDomain>>()

    init {
        viewModelScope.launch{

        }
    }

    fun getLessonLiveData(): LiveData<List<LessonDomain>> = lessonLiveData
}