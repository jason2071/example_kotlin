package com.example.demokotlin.register_login.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demokotlin.R
import com.example.demokotlin.register_login.model.AllMember
import com.example.demokotlin.register_login.model.Results
import kotlinx.android.synthetic.main.item_member_layout.view.*

private const val ADMIN_VIEW = 1
private const val MEMBER_VIEW = 2
private const val TEACHER_VIEW = 3

class MemberAdapter(
    private var allMember: AllMember,
    private val itemClickInterface: SetItemClickInterface
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (allMember.results!![position].system) {
            "1" -> ADMIN_VIEW
            "2" -> MEMBER_VIEW
            else -> TEACHER_VIEW
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val view = when (viewType) {
            ADMIN_VIEW -> LayoutInflater.from(parent.context).inflate(R.layout.item_admin_layout, parent, false)
            MEMBER_VIEW -> LayoutInflater.from(parent.context).inflate(R.layout.item_member_layout, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.item_member_layout, parent, false)
        }
        return MemberViewHolder(view)
    }

    override fun getItemCount() = if (allMember.results != null) allMember.results!!.size else 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MemberViewHolder
        holder.bind(allMember.results!![position], itemClickInterface)
    }

    class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(results: Results, itemClickInterface: SetItemClickInterface) {
            itemView.tvName.text = results.name
            itemView.tvHserHash.text = results.user_hash

            itemView.setOnClickListener {
                itemClickInterface.itemClick(results)
            }
        }
    }

    interface SetItemClickInterface{
        fun itemClick(results: Results)
    }
}