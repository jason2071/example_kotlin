package com.example.demokotlin.settle.main

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.demokotlin.R
import com.example.demokotlin.databinding.ItemLayoutSettle2Binding
import com.example.demokotlin.databinding.ItemLayoutSettleBinding
import com.example.demokotlin.settle.SettleModel


private const val TYPE_ZERO = 0
private const val TYPE_POSITIVE = 1

class SettleAdapter(private val mContext: Context, private var list: ArrayList<SettleModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateList(list: ArrayList<SettleModel>) {
        if (list.isNotEmpty()) {
            this.list = list
            notifyDataSetChanged()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].totalSaleAmount > 0) TYPE_ZERO else TYPE_POSITIVE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_ZERO -> {
                val binding: ItemLayoutSettleBinding =
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_layout_settle,
                        parent,
                        false
                    )
                return SettleViewHolder(binding)
            }
            TYPE_POSITIVE -> {
                val binding: ItemLayoutSettle2Binding =
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_layout_settle2,
                        parent,
                        false
                    )
                return Settle2ViewHolder(binding)
            }
            else -> {
                val binding: ItemLayoutSettleBinding =
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_layout_settle,
                        parent,
                        false
                    )
                return SettleViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (list.isEmpty()) 0 else list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SettleViewHolder -> {
                holder.bindSettle(list[position])
            }
            is Settle2ViewHolder -> {
                holder.bindSettle2(list[position])
            }
        }
    }

    inner class SettleViewHolder(private val binding: ItemLayoutSettleBinding) :
        RecyclerView.ViewHolder(binding.linearLayout) {
        fun bindSettle(settleModel: SettleModel) {
            if (binding.viewModel == null) {
                binding.viewModel = ItemViewModel(mContext, settleModel)
            } else {
                binding.viewModel!!.update(settleModel)
            }
        }
    }

    inner class Settle2ViewHolder(private val binding: ItemLayoutSettle2Binding) :
        RecyclerView.ViewHolder(binding.linearLayout) {
        fun bindSettle2(settleModel: SettleModel) {
            if (binding.viewModel == null) {
                binding.viewModel = ItemViewModel(mContext, settleModel)
            } else {
                binding.viewModel!!.update(settleModel)
            }
        }
    }
}