package com.example.demokotlin.settle.main

import android.databinding.BaseObservable
import android.text.Editable
import android.text.TextWatcher
import com.example.demokotlin.ViewModel
import com.example.demokotlin.settle.SettleModel

class SettleViewModel(
    private var list: ArrayList<SettleModel>,
    private val dataListener: DataListener
) : BaseObservable(), ViewModel {

    private var keyword = ""

    val editTextKeyword: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                keyword = s.toString()
                findDataList(keyword)
            }
        }

    private fun findDataList(keyword: String) {
        if (keyword.isEmpty()) {
            dataListener.onSearchDataListener(list)
        }

        val result = arrayListOf<SettleModel>()
        for (i in 0 until list.size) {
            if (list[i].cardSchemeName!!.toLowerCase().contains(keyword)) {
                result += list[i]
            }
        }
        dataListener.onSearchDataListener(result)
    }

    override fun destroy() {

    }

    interface DataListener {
        fun onSearchDataListener(result: ArrayList<SettleModel>)
    }
}