package com.example.shambadataapi.utils

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(context: Context):Interceptor {
    private val sessionManager = SessionManager(context)
    override fun intercept(chain: Interceptor.Chain): Response {
       val requestBuilder = chain.request().newBuilder()

        sessionManager.fetchAuthToken()?.let {
            requestBuilder.addHeader("Authorization","Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}