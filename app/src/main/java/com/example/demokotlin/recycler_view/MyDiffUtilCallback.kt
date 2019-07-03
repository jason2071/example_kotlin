package com.example.demokotlin.recycler_view

import android.support.v7.util.DiffUtil

class MyDiffUtilCallback(private val oldData: ArrayList<Any>, private val newData: ArrayList<Any>): DiffUtil.Callback() {

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldPosition == newPosition
    }

    override fun getOldListSize(): Int {
        return oldData.size
    }

    override fun getNewListSize(): Int {
        return newData.size
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldData[oldPosition] == newData[newPosition]
    }
}