package com.h3solution.testapimvvm.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.h3solution.testapimvvm.R
import com.h3solution.testapimvvm.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.userLiveData.observe(this, Observer {
            if (it != null) {
                tvData.text = it.toString()
            }
        })

        btnCallApi.setOnClickListener {
            userViewModel.fetchUser(edtId.text.toString().toInt())
        }
    }
}
