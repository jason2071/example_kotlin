package com.example.demokotlin.fragment.main_demo

import com.example.demokotlin.model.Product

interface MainResultInterface {
    fun success(data: Any?)
    fun error(message: String)
}