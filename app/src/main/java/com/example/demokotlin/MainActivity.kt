package com.example.demokotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.demokotlin.datepicker.DatepickerActivity
import com.example.demokotlin.menu.MainMenu
import com.example.demokotlin.menu.MainMenuAdapter
import com.example.demokotlin.mvvm.LoginMvvmActivity
import com.example.demokotlin.reader.ReaderActivity
import com.example.demokotlin.recycler_view.UpdateRecyclerViewActivity
import com.example.demokotlin.settle.main.SettleActivity
import com.example.demokotlin.spinner.SpinnerActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainMenuAdapter.SetOnClickListener {

    private var listener: MainMenuAdapter.SetOnClickListener = this
    private var menu = ArrayList<MainMenu>()
    private lateinit var mAdapter: MainMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addMenuData()
        buildRecyclerView()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////// RECYCLER VIEW ///////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private fun buildRecyclerView() {
        mainRecyclerView.setHasFixedSize(true)
        mainRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        mAdapter = MainMenuAdapter(MainMenuAdapter.PassMenuData(menu, listener))
        mainRecyclerView.adapter = mAdapter
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////// OVERRIDE INTERFACE /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onItemClickListener(activity: Class<out Activity>, title: String) {
        val intent = Intent(this@MainActivity, activity)
        startActivity(intent)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////// DATA SOURCE /////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private fun addMenuData() {
        menu.add(MainMenu(UpdateRecyclerViewActivity::class.java, "UpdateRecyclerView"))
        menu.add(MainMenu(LoginMvvmActivity::class.java, "Login MVVM"))
        menu.add(MainMenu(SpinnerActivity::class.java, "Spinner"))
        menu.add(MainMenu(DatepickerActivity::class.java, "Datepicker"))
        menu.add(MainMenu(ReaderActivity::class.java, "Reader"))
        menu.add(MainMenu(SettleActivity::class.java, "Settle"))
    }
}
