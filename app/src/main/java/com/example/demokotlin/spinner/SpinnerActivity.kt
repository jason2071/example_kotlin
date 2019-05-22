package com.example.demokotlin.spinner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.demokotlin.model.Data
import kotlinx.android.synthetic.main.activity_spinner.*
import android.widget.AdapterView
import android.view.View
import com.example.demokotlin.R


class SpinnerActivity : AppCompatActivity() {

    private var list = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        initData()

        val adapter = SpinnerAdapter(this, list)
        spinnerData.adapter = adapter

        spinnerData.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectItem(parent, position)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun selectItem(parent: AdapterView<*>, position: Int) {
        val item = parent.getItemAtPosition(position) as Data
        val productName = item.product_name
        Toast.makeText(this, "selected: $productName", Toast.LENGTH_SHORT).show()
    }

    private fun log(s: String) {
        Log.d("SpinnerActivityTag", s)
    }

    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

    private fun initData() {
        list.add(Data("2019-05-15", 1, "product1", 1, 10, "2019-05-15"))
        list.add(Data("2019-05-15", 2, "product2", 1, 10, "2019-05-15"))
        list.add(Data("2019-05-16", 3, "product3", 1, 10, "2019-05-16"))
        list.add(Data("2019-05-17", 4, "product4", 1, 10, "2019-05-17"))
        list.add(Data("2019-05-17", 5, "product5", 1, 10, "2019-05-17"))
    }
}
