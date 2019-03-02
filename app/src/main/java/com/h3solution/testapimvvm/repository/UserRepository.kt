package com.h3solution.testapimvvm.repository

import com.h3solution.testapimvvm.base.BaseRepository
import com.h3solution.testapimvvm.model.User
import com.h3solution.testapimvvm.network.Api

class UserRepository(private val api: Api) : BaseRepository() {
    suspend fun getUserById(id: Int): User? {
        return safeApiCall({ api.getGithubUserById(id).await() }, "Error fetching User")
    }
}