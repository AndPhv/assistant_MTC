package com.example.assistant_mtc.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assistant_mtc.app.App
import com.sogya.mtc.domain.models.LessonDomain
import com.sogya.mtc.domain.usecase.lesson.GetAllLessonsUseCase
import com.sogya.mtc.domain.usecase.lesson.InsertLessonsUseCase
import com.sogya.mtc.domain.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class HomeVM : ViewModel() {
    private val lessonRepository = App.getLessonRepository()
    private val networkRepository = App.getNetworkRepository()
    private val getLessonsUseCase = GetAllLessonsUseCase(lessonRepository)
    private var lessonLiveData: LiveData<List<LessonDomain>> = MutableLiveData()
    private val insertLessonsUseCase = InsertLessonsUseCase(lessonRepository)
    private val groupId: Int? = null
    private val errorLiveData = MutableLiveData<String>()

    fun getHomeLiveData(): LiveData<List<LessonDomain>> = lessonLiveData
    fun getErrorLiveData(): LiveData<String> = errorLiveData

    init {
        lessonLiveData = getLessonsUseCase()
        updateTimeTable()
    }

    private fun updateTimeTable() {
        networkRepository.getLessonsByGroupId(token = Constants.BASE_TOKEN, groupId = groupId!!)
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