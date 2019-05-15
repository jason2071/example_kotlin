package com.example.demokotlin.mvvm

import android.util.Patterns

class User {
    var email: String = ""
    var password: String = ""

    val isLoginValid: Int
        get() = when {
            email.trim().isEmpty() -> 0
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> 1
            password.trim().length < 6 -> 2
            else -> -1
        }
}