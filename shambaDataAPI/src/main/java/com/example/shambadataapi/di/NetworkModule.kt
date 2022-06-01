package com.example.shambadataapi.di

import android.content.Context
import android.os.Build
import com.example.shambadataapi.api.ShambaDataRequests
import com.example.shambadataapi.utils.AuthenticationInterceptor
import com.example.shambadataapi.utils.Constants.SHAMBA_DATA_BASE_URL
import com.example.shambadataapi.utils.SessionManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration

val shambaDataModule = module {
    factory { provideOkHttpClientInterceptor() }
    factory { provideOkHttpClient(get(),get()) }
    factory { provideRetrofit(get()) }
//    factory { interceptor }
    single { provideShambaDataApi(get()) }

}


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(SHAMBA_DATA_BASE_URL)
        .build()
}

fun provideOkHttpClientInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}

//val interceptor = Interceptor { chain ->
//    val response = chain.proceed(chain.request())
//    var locationHistory = mutableListOf<String>()
//    locationHistory.add(response.header("Location")?: "empty")
//    response
//}


fun provideOkHttpClient(context: Context,httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(AuthenticationInterceptor(context))
            .readTimeout(Duration.ofMinutes(2))
            .build()
    } else {
        TODO("VERSION.SDK_INT < O")
    }
}

fun provideShambaDataApi(retrofit: Retrofit):ShambaDataRequests{
    return retrofit.create(ShambaDataRequests::class.java)
}