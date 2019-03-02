package com.h3solution.testapimvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.h3solution.testapimvvm.base.BaseViewModel
import com.h3solution.testapimvvm.model.User
import com.h3solution.testapimvvm.network.Api
import com.h3solution.testapimvvm.network.ApiFactory
import com.h3solution.testapimvvm.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : BaseViewModel() {
    private val api = ApiFactory.retrofit().create(Api::class.java)
    private val repository = UserRepository(api)

    val userLiveData = MutableLiveData<User>()

    fun fetchUser(id: Int) {
        scope.launch {
            val user = repository.getUserById(id)
            userLiveData.postValue(user)
        }
    }
}