package com.example.demokotlin.recycler_view

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demokotlin.R
import kotlinx.android.synthetic.main.item_update_layout.view.*

class MyAdapter(private val dataSource: ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_update_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSource[position])
    }

    fun insertItem(newList: ArrayList<String>) {
        val diffUtilCallback = MyDiffUtilCallback(dataSource as ArrayList<Any>, newList as ArrayList<Any>)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        dataSource.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun updateItem(newList: ArrayList<String>) {
        val diffUtilCallback = MyDiffUtilCallback(dataSource as ArrayList<Any>, newList as ArrayList<Any>)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        dataSource.clear()
        dataSource.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(message: String) {
            itemView.textViewMessage.text = message
        }
    }
}