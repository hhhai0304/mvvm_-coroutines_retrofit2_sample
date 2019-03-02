package com.h3solution.testapimvvm.model

import com.h3solution.testapimvvm.base.BaseModel

data class User(
    val name: String,
    val id: Int,
    val email: String,
    val website: String
) : BaseModel()