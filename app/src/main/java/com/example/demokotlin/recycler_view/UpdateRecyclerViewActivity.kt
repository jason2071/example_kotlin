package com.example.demokotlin.recycler_view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.demokotlin.R
import kotlinx.android.synthetic.main.activity_update_recycler_view.*
import java.util.*

class UpdateRecyclerViewActivity : AppCompatActivity() {

    private val dataSource: ArrayList<String> = ArrayList()
    private lateinit var adapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_recycler_view)
        initData()

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(dataSource)
        recyclerView.adapter = adapter

        btnInsert.setOnClickListener {
            val newData = arrayListOf<String>()
            for (i in 0..2) {
                newData.add(UUID.randomUUID().toString())
            }
            adapter.insertItem(newData)
            recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
        }

        btnUpdate.setOnClickListener {
            val newData = arrayListOf<String>()
            for (i in 0..2) {
                newData.add(UUID.randomUUID().toString())
            }
            adapter.updateItem(newData)
        }

    }

    private fun initData() {
        for (i in 0..1) {
            dataSource.add(UUID.randomUUID().toString())
        }
    }
}
