package com.example.demokotlin.reader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.demokotlin.R
import com.example.demokotlin.reader.interfaces.ResponseInterface
import com.example.demokotlin.reader.manager.RabbitObject.writeModel
import com.example.demokotlin.reader.model.BaseResponse
import com.example.demokotlin.utils.log
import com.google.gson.Gson

class ReaderActivity : AppCompatActivity(), ResponseInterface {

    private var responseInterface: ResponseInterface = this
    private lateinit var readerCancel: ReaderCancel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader)
        readerCancel = ReaderCancel(responseInterface)
        readerCancel.cancel()
    }

    override fun onResponseSuccess(response: Any) {
        response as BaseResponse
        "status: ${response.status}".log()
        "writeList: ${Gson().toJson(response.writeDataList)}".log()
        "writeModel: ${Gson().toJson(writeModel)}".log()
    }
}
