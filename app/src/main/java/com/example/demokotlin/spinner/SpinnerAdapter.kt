package com.example.demokotlin.spinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.demokotlin.R
import com.example.demokotlin.model.Data
import kotlinx.android.synthetic.main.item_spinner_layout.view.*


class SpinnerAdapter(context: Context, list: ArrayList<Data>) : ArrayAdapter<Data>(context, 0, list) {

    private var view: View? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        view = convertView
        view = LayoutInflater.from(context).inflate(R.layout.item_spinner_layout, parent, false)
        val item = getItem(position)
        if (item != null) view!!.tvTitleSpinner.text = item.product_name
        return view!!
    }
}

