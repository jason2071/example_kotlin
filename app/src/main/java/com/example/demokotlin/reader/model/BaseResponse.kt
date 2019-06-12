package com.example.demokotlin.reader.model

data class BaseResponse(
    var status: Boolean = false
    , var writeDataList: MutableList<Byte> = arrayListOf()
    , var readDataList: MutableList<Byte> = arrayListOf()
)