package com.example.demokotlin.mvvm

interface ResultLoginCallback{
    fun onSuccess(message: String)
    fun onError(message: String)
}