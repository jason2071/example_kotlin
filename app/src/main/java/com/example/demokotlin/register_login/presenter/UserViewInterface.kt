package com.example.demokotlin.register_login.presenter

import com.example.demokotlin.BaseItemViewInterface

interface UserViewInterface: BaseItemViewInterface {
    fun onSuccess(data: Any?)
}