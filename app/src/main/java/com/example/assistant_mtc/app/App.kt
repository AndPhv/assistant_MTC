package com.example.assistant_mtc.app

import android.app.Application
import com.sogya.mtc.data.repository.LessonRepositoryImpl
import com.sogya.mtc.data.repository.NetworkRepositoryImpl
import com.sogya.mtc.domain.repository.LessonRepository
import com.sogya.mtc.domain.repository.NetworkRepository

class App : Application() {

    companion object {
        private lateinit var app: App
        private lateinit var networkRepository: NetworkRepository
        private lateinit var lessonRepository: LessonRepository

        fun getLessonRepository(): LessonRepository = lessonRepository

        fun getNetworkRepository(): NetworkRepository = networkRepository
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        lessonRepository = LessonRepositoryImpl(applicationContext)
        networkRepository = NetworkRepositoryImpl()
    }
}