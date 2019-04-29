package com.example.demokotlin.register_login.presenter

import com.example.demokotlin.fragment.main_demo.MainResultInterface
import com.example.demokotlin.manager.Http.RetrofitManager
import com.example.demokotlin.register_login.model.PassParameterModel
import com.example.demokotlin.utils.NetworkUtil

class UserPresenter(private var userViewInterface: UserViewInterface) : MainResultInterface {

    private var mainResultInterface: MainResultInterface = this
    private val retrofitManager = RetrofitManager(mainResultInterface)

    fun getAllMember() {
        if (NetworkUtil().isNetworkAvailable) {
            userViewInterface.onShowFullProgressView()
            retrofitManager.getAllMember()
        } else {
            userViewInterface.onDialogNoInternet()
        }
    }

    fun getMemberDetail(user_hash: String) {
        if (NetworkUtil().isNetworkAvailable) {
            userViewInterface.onShowFullProgressView()
            retrofitManager.getMemberDetail(user_hash)
        } else {
            userViewInterface.onDialogNoInternet()
        }
    }

    fun validateLogin(passParameterModel: PassParameterModel) {
        if (NetworkUtil().isNetworkAvailable) {
            userViewInterface.onShowFullProgressView()
            retrofitManager.userLogin(passParameterModel)
        } else {
            userViewInterface.onDialogNoInternet()
        }
    }

    fun validateRegister(passParameterModel: PassParameterModel) {
        if (NetworkUtil().isNetworkAvailable) {
            userViewInterface.onShowFullProgressView()
            retrofitManager.userRegister(passParameterModel)
        } else {
            userViewInterface.onDialogNoInternet()
        }
    }

    override fun success(data: Any?) {
        userViewInterface.onHideFullProgressView()
        userViewInterface.onSuccess(data)
    }

    override fun error(message: String) {
        userViewInterface.onHideFullProgressView()
        userViewInterface.onDialogError(message)
    }
}