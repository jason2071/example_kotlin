package com.example.demokotlin.reader.interfaces

import com.example.demokotlin.reader.model.BaseResponse

interface ReaderInterface {
    fun onReaderSuccess(response: BaseResponse)
    fun onReaderError(status: Boolean)
}