package com.sogya.mtc.domain.utils

interface CallbackListener<T> {
    fun data(data: T){}
    fun error(error: String) {}
}