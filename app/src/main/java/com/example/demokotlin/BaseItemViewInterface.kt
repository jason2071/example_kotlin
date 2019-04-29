package com.example.demokotlin

import android.view.View

interface BaseItemViewInterface {
    fun onReturnView(view: View)
    fun onShowFullProgressView()
    fun onHideFullProgressView()
    fun onDialogNoInternet()
    fun onDialogError(message: String)
}