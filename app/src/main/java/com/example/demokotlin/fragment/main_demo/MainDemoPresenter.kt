package com.example.demokotlin.fragment.main_demo

import android.content.Context
import com.example.demokotlin.manager.Http.RetrofitManager
import com.example.demokotlin.model.Product
import com.example.demokotlin.utils.NetworkUtil

class MainDemoPresenter(
    private val mContext: Context,
    private var mainViewInterface: MainViewInterface
) : MainResultInterface {

    private var mainResultInterface: MainResultInterface = this

    private val retrofitManager = RetrofitManager(mainResultInterface)

    fun validate(page: Int) {

        if (NetworkUtil().isNetworkAvailable) {
            mainViewInterface.onShowFullProgressView()
            retrofitManager.getProduct(page)
        } else {
            mainViewInterface.onDialogNoInternet()
        }
    }

    override fun success(data: Any?) {
        val product = data as Product
        mainViewInterface.onHideFullProgressView()
        mainViewInterface.onResultProduct(product)
    }

    override fun error(message: String) {
        mainViewInterface.onHideFullProgressView()
        mainViewInterface.onDialogError(message)
    }
}