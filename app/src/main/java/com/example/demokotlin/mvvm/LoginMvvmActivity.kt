package com.example.demokotlin.mvvm

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.demokotlin.R
import com.example.demokotlin.databinding.ActivityLoginMvvmBinding
import es.dmoral.toasty.Toasty

class LoginMvvmActivity : AppCompatActivity(), ResultLoginCallback {

    private lateinit var binding: ActivityLoginMvvmBinding
    private lateinit var loginViewModel: LoginViewModel
    private var resultListener: ResultLoginCallback = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_mvvm)
        loginViewModel = LoginViewModel(resultListener)
        binding.vm = loginViewModel
    }

    override fun onSuccess(message: String) {
        Toasty.success(this, message, Toasty.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this, message, Toasty.LENGTH_SHORT).show()
    }
}
