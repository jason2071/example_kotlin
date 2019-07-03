package com.example.demokotlin.settle.main

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.demokotlin.R
import com.example.demokotlin.databinding.ActivitySettle2Binding
import com.example.demokotlin.settle.SettleData
import com.example.demokotlin.settle.SettleModel

class SettleActivity : AppCompatActivity(), SettleViewModel.DataListener {

    private val dataListener: SettleViewModel.DataListener = this

    private lateinit var binding: ActivitySettle2Binding
    private lateinit var settleViewModel: SettleViewModel

    private lateinit var adapter: SettleAdapter
    private val list = SettleData.getJsonData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settle2)
        settleViewModel = SettleViewModel(list, dataListener)
        binding.viewModel = settleViewModel
        setupRecyclerView(binding.settleRecyclerView)
    }

    private fun setupRecyclerView(settleRecyclerView: RecyclerView) {
        adapter = SettleAdapter(this@SettleActivity, list)
        settleRecyclerView.setHasFixedSize(true)
        settleRecyclerView.layoutManager = LinearLayoutManager(this)
        settleRecyclerView.adapter = adapter
        settleRecyclerView.smoothScrollToPosition(adapter.itemCount - 1)
    }

    override fun onSearchDataListener(result: ArrayList<SettleModel>) {
        adapter.updateList(result)
    }

    override fun onDestroy() {
        super.onDestroy()
        settleViewModel.destroy()
    }
}
