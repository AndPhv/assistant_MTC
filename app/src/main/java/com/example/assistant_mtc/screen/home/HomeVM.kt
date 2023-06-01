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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    getLessonsUseCase:GetAllLessonsUseCase,
    private val insertLessonsUseCase:InsertLessonsUseCase,
    private val getLessonsByGroupIdUseCase: GetLessonsByGroupIdUseCase
): ViewModel() {
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
        getLessonsByGroupIdUseCase(token = Constants.BASE_TOKEN, groupId = groupId!!)
            .subscribeOn(
                Schedulers.io()
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<List<LessonDomain>>() {
                override fun onSuccess(t: List<LessonDomain>) {
                    viewModelScope.launch {
                        insertLessonsUseCase.invoke(t)
                    }
                }

                override fun onError(e: Throwable) {
                    errorLiveData.postValue(e.message)
                }
            })
    }
}