package com.example.demokotlin.register_login

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.demokotlin.R
import com.example.demokotlin.register_login.model.Results
import kotlinx.android.synthetic.main.activity_member_detail.*

class MemberDetailActivity : AppCompatActivity() {

    private var results: Results? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_detail)

        val bundle = intent.extras
        if (bundle != null) {
            results = bundle.getParcelable("results")
        }

        tvId.text = "ID: " + results!!.id
        tvUserHash.text = "USER_HASH: " + results!!.user_hash
        tvName.text = "NAME: " + results!!.name
        tvEmail.text = "EMAIL: " + results!!.email
        tvSystem.text = "POSITION: " + if (results!!.system == "1") "ADMIN" else "MEMBER"
    }
}
