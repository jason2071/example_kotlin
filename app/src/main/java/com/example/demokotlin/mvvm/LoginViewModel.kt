package com.example.demokotlin.mvvm

import android.text.Editable
import android.text.TextWatcher
import android.view.View

class LoginViewModel(private val resultListener: ResultLoginCallback) {

    private var user = User()

    val emailEditTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                user.email = s.toString()
            }
        }

    val passwordEditTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                user.password = s.toString()
            }
        }

    fun onClickLogin(v: View) {
        when (user.isLoginValid) {
            0 -> resultListener.onError("Email is empty.")
            1 -> resultListener.onError("Invalid email format.")
            2 -> resultListener.onError("Password must have 6 or more.")
            else -> resultListener.onSuccess("Login Success.")
        }
    }
}