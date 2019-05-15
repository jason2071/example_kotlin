package com.example.demokotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.demokotlin.activity.LayoutActivity
import com.example.demokotlin.register_login.common.Member
import com.example.demokotlin.common.Page
import com.example.demokotlin.menu.MainMenu
import com.example.demokotlin.menu.MainMenuAdapter
import com.example.demokotlin.mvvm.LoginMvvmActivity
import com.example.demokotlin.recycler_view.UpdateRecyclerViewActivity
import com.example.demokotlin.register_login.RegisterLoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainMenuAdapter.SetOnClickListener {

    private val menu = ArrayList<MainMenu>()
    private var listener: MainMenuAdapter.SetOnClickListener = this
    private lateinit var mAdapter: MainMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addMenu()
        recyclerView()
    }

    private fun addMenu() {
        menu.add(MainMenu(UpdateRecyclerViewActivity::class.java, "UpdateRecyclerView"))
        menu.add(MainMenu(LoginMvvmActivity::class.java, "Login MVVM"))
    }

    private fun recyclerView() {
        mainRecyclerView.setHasFixedSize(true)
        mainRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        mAdapter = MainMenuAdapter(menu, listener)
        mainRecyclerView.adapter = mAdapter
    }

    override fun onItemClickListener(activity: Class<out Activity>, title: String) {
        val intent = Intent(this@MainActivity, activity)
        startActivity(intent)
    }
}
