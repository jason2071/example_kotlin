package com.example.demokotlin.manager.Http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofit: Retrofit? = null
    private var baseUrl = "http://172.21.26.45:3000/"

    val apiService: ApiService
        get() = RetrofitClient.getClient(baseUrl).create(ApiService::class.java)

    private fun getClient (baseUrl: String): Retrofit {
        if(retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}