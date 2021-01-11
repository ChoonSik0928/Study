package com.choonsik.study.mvvm.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

fun <Dto> performGetOperation(
    networkCall: suspend () -> Resource<Dto>,
    successCallResult: suspend (Dto) -> Unit
): LiveData<Resource<Dto>> = liveData(Dispatchers.IO) {
    emit(Resource.loading())
    val responseStatus = networkCall.invoke()

    if (responseStatus.status == Resource.Status.SUCCESS) {
        successCallResult(responseStatus.data!!)
    } else if (responseStatus.status == Resource.Status.ERROR) {
        emit(Resource.error(responseStatus.message!!))
    }
}