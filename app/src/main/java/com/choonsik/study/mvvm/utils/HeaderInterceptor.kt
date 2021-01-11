package com.choonsik.study.mvvm.utils

import android.os.Build
import com.choonsik.study.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import java.util.*
import kotlin.collections.HashMap

class HeaderInterceptor  : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
        val map = getPublicApiHeader()
        map.forEach { (type, value) -> request.addHeader(type, value) }

        if (BuildConfig.DEBUG) {
            Timber.d("header = ${request.build().headers}")
        }

        return chain.proceed(request.build())
    }

    private fun getPublicApiHeader(): MutableMap<String, String> {
        val headerMap = HashMap<String, String>()
        // headerMap["os"] = "android"
        return headerMap
    }

}