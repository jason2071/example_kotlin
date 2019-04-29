package com.example.demokotlin.utils

import android.content.Context
import android.net.ConnectivityManager
import com.example.demokotlin.manager.Contextor


class NetworkUtil {
    val isNetworkAvailable: Boolean
        get() {
            return try {
                val connectivityManager =
                    Contextor.getInstance().context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                activeNetworkInfo != null
            } catch (e: Exception) {
                true
            }
        }
}