package com.example.demokotlin.settle.main

import android.content.Context
import android.databinding.BaseObservable
import android.view.View
import android.widget.Toast
import com.example.demokotlin.ViewModel
import com.example.demokotlin.settle.SettleModel
import es.dmoral.toasty.Toasty

class ItemViewModel(
    private val mContext: Context
    , private var settleModel: SettleModel
) : BaseObservable(), ViewModel {

    val cardSchemeName: String
        get() = settleModel.cardSchemeName!!


    fun update(settleModel: SettleModel) {
        this.settleModel = settleModel
        notifyChange()
    }

    fun onItemClick(v: View) {
        Toasty.success(mContext, settleModel.cardSchemeName!!, Toast.LENGTH_SHORT).show()
    }

    override fun destroy() {

    }
}