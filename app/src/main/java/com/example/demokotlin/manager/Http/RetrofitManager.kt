package com.example.demokotlin.manager.Http

import com.example.demokotlin.model.Product
import com.example.demokotlin.fragment.main_demo.MainResultInterface
import com.example.demokotlin.register_login.model.AllMember
import com.example.demokotlin.register_login.model.BaseResponse
import com.example.demokotlin.register_login.model.PassParameterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitManager(var mainResultInterface: MainResultInterface) {

    private var mService: ApiService = RetrofitClient.apiService

    fun getProduct(page: Int) {
        val callProduct = mService.getProduct(page)
        callProduct.enqueue(object : Callback<Product> {
            override fun onFailure(call: Call<Product>, t: Throwable) {
                mainResultInterface.error("Failure")
            }

            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    mainResultInterface.success(response.body())
                } else {
                    mainResultInterface.error("Response error.")
                }

            }
        })
    }

    fun getAllMember() {
        val callUserLogin = mService.getAllMember()
        callUserLogin.enqueue(object : Callback<AllMember>{
            override fun onFailure(call: Call<AllMember>, t: Throwable) {
                mainResultInterface.error("getAllMember: Failure")
            }

            override fun onResponse(call: Call<AllMember>, response: Response<AllMember>) {
                if (response.isSuccessful) {
                    mainResultInterface.success(response.body())
                } else {
                    mainResultInterface.error("getAllMember: Response error.")
                }
            }
        })
    }

    fun getMemberDetail(user_hash: String) {
        val callUserLogin = mService.getMemberDetail(user_hash)
        callUserLogin.enqueue(object : Callback<BaseResponse>{
            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                mainResultInterface.error("getMemberDetail: Failure")
            }

            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {
                    mainResultInterface.success(response.body())
                } else {
                    mainResultInterface.error("getMemberDetail: Response error.")
                }
            }
        })
    }

    fun userLogin(passParameterModel: PassParameterModel) {
        val callUserLogin = mService.requestUserLogin(passParameterModel.email, passParameterModel.password)
        callUserLogin.enqueue(object : Callback<BaseResponse>{
            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                mainResultInterface.error("userLogin: Failure")
            }

            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {
                    mainResultInterface.success(response.body())
                } else {
                    mainResultInterface.error("userLogin: Response error.")
                }
            }
        })
    }

    fun userRegister(passParameterModel: PassParameterModel) {
        val callUserLogin = mService.requestUserRegister(passParameterModel.name,passParameterModel.email, passParameterModel.password)
        callUserLogin.enqueue(object : Callback<BaseResponse>{
            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                mainResultInterface.error("userRegister: Failure")
            }

            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                if (response.isSuccessful) {
                    mainResultInterface.success(response.body())
                } else {
                    mainResultInterface.error("userRegister: Response error.")
                }
            }
        })
    }
}