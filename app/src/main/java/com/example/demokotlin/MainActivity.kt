package com.example.demokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.demokotlin.activity.LayoutActivity
import com.example.demokotlin.register_login.common.Member
import com.example.demokotlin.common.Page
import com.example.demokotlin.recycler_view.UpdateRecyclerViewActivity
import com.example.demokotlin.register_login.RegisterLoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainFragment.setOnClickListener {
            val intent = Intent(this, LayoutActivity::class.java)
            intent.putExtra("demo_page", Page.MAIN)
            startActivity(intent)
        }

        btnFragment1.setOnClickListener {
            val intent = Intent(this, LayoutActivity::class.java)
            intent.putExtra("demo_page", Page.PAGE1)
            startActivity(intent)
        }

        btnFragment2.setOnClickListener {
            val intent = Intent(this, LayoutActivity::class.java)
            intent.putExtra("demo_page", Page.PAGE2)
            startActivity(intent)
        }

        btnUpdateRecyclerView.setOnClickListener {
            val intent = Intent(this, UpdateRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        btnAllMember.setOnClickListener {
            val intent = Intent(this, RegisterLoginActivity::class.java)
            intent.putExtra("validateRegisterLogin", Member.LIST)
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterLoginActivity::class.java)
            intent.putExtra("validateRegisterLogin", Member.REGISTER)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this, RegisterLoginActivity::class.java)
            intent.putExtra("validateRegisterLogin", Member.LOGIN)
            startActivity(intent)
        }

    }
}
