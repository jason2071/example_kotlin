package com.example.demokotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.demokotlin.R
import com.example.demokotlin.common.Page
import com.example.demokotlin.fragment.MainFragment
import com.example.demokotlin.fragment.OneFragment
import com.example.demokotlin.fragment.TwoFragment
import java.io.Serializable


class LayoutActivity : AppCompatActivity() {

    private var manager = supportFragmentManager
    private var page: Serializable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        val bundle = intent.extras
        if (bundle != null) {
            page = bundle.getSerializable("demo_page")
        }

        when (page) {
            Page.MAIN -> {
                manager.beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance())
                    .commitAllowingStateLoss()
            }
            Page.PAGE1 -> {
                manager.beginTransaction()
                    .add(R.id.contentContainer, OneFragment.newInstance())
                    .commitAllowingStateLoss()
            }
            Page.PAGE2 -> {
                manager.beginTransaction()
                    .add(R.id.contentContainer, TwoFragment.newInstance())
                    .commitAllowingStateLoss()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
