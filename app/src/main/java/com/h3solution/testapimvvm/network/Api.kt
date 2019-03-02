package com.h3solution.testapimvvm.network

import com.h3solution.testapimvvm.model.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{id}")
    fun getGithubUserById(@Path("id") id: Int): Deferred<Response<User>>
}