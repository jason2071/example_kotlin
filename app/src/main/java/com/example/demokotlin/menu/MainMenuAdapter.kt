package com.example.demokotlin.menu

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demokotlin.R
import kotlinx.android.synthetic.main.item_menu_layout.view.*

class MainMenuAdapter(
    private val mainMenus: ArrayList<MainMenu>,
    private val listener: SetOnClickListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mainMenus.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MainViewHolder
        holder.bind(mainMenus[position], listener)
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mainMenu: MainMenu, listener: SetOnClickListener) {
            itemView.tvTitle.text = mainMenu.mExampleName
            itemView.setOnClickListener {
                listener.onItemClickListener(mainMenu.mExampleActivityClass, mainMenu.mExampleName)
            }
        }
    }

    interface SetOnClickListener {
        fun onItemClickListener(activity: Class<out Activity>, title: String)
    }
}