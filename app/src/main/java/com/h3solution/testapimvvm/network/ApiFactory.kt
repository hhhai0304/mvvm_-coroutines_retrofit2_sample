package com.h3solution.testapimvvm.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {
    private val authInterceptor = Interceptor {
        val newUrl = it.request().url().newBuilder().build()
        val newRequest = it.request().newBuilder().url(newUrl).build()
        it.proceed(newRequest)
    }

    fun retrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient().newBuilder().addInterceptor(authInterceptor).addInterceptor(interceptor).build()

        return Retrofit.Builder().client(client)
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }
}