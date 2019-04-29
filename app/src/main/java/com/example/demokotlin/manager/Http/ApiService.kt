package com.example.demokotlin.manager.Http

import com.example.demokotlin.model.Product
import com.example.demokotlin.register_login.model.AllMember
import com.example.demokotlin.register_login.model.BaseResponse
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded


interface ApiService {

    @GET("api/product")
    fun getProduct(@Query("page") page: Int): Call<Product>

    @GET("member")
    fun getAllMember(): Call<AllMember>

    @GET("member/detail")
    fun getMemberDetail(@Query("user_hash") user_hash: String): Call<BaseResponse>

    @FormUrlEncoded
    @POST("member/login")
    fun requestUserLogin(@Field("email") email: String , @Field("password") password: String): Call<BaseResponse>

    @FormUrlEncoded
    @POST("member/register")
    fun requestUserRegister(@Field("name") name: String , @Field("email") email: String , @Field("password") password: String): Call<BaseResponse>
}