package com.example.demokotlin.utils

import android.util.Log
import com.example.demokotlin.BuildConfig


private const val TAG = "MainActivityA"

fun Any.log(tag: String = TAG) {
    if (!BuildConfig.DEBUG) return
    if (this is String) {
        Log.d(tag, this)
    } else {
        Log.d(tag, this.toString())
    }
}