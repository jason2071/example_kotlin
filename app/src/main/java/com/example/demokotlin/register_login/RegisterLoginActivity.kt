package com.example.demokotlin.register_login

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.demokotlin.R
import com.example.demokotlin.register_login.common.Member
import com.example.demokotlin.register_login.fragment.AllMemberFragment
import com.example.demokotlin.register_login.fragment.LoginFragment
import com.example.demokotlin.register_login.model.AllMember
import com.example.demokotlin.register_login.presenter.UserPresenter
import com.example.demokotlin.register_login.presenter.UserViewInterface
import java.io.Serializable

class RegisterLoginActivity : AppCompatActivity(), UserViewInterface {

    private var manager = supportFragmentManager
    private var loginType: Serializable? = null

    private lateinit var userPresenter: UserPresenter
    private var userViewInterface: UserViewInterface = this

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_login)

        userPresenter = UserPresenter(userViewInterface)

        val bundle = intent.extras
        if (bundle != null) {
            loginType = bundle.getSerializable("validateRegisterLogin")
        }

        when (loginType) {
            Member.LIST -> userPresenter.getAllMember()
            Member.REGISTER -> useFragment(null)
            Member.LOGIN -> useFragment(null)
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////// OVERRIDE INTERFACE ///////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onSuccess(data: Any?) {
        when (loginType) {
            Member.LIST -> useFragment(data)
        }
    }

    override fun onReturnView(view: View) {

    }

    override fun onShowFullProgressView() {

    }

    override fun onHideFullProgressView() {

    }

    override fun onDialogNoInternet() {

    }

    override fun onDialogError(message: String) {
        log(message)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////// FRAGMENT //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private fun useFragment(data: Any?) {
        when (loginType) {
            Member.LIST -> {
                manager.beginTransaction()
                    .replace(R.id.memberContentContainer, AllMemberFragment.newInstance(data as AllMember))
                    .commitAllowingStateLoss()
            }
            Member.REGISTER -> {
                manager.beginTransaction()
                    .replace(R.id.memberContentContainer, LoginFragment.newInstance(Member.REGISTER))
                    .commitAllowingStateLoss()
            }
            Member.LOGIN -> {
                manager.beginTransaction()
                    .replace(R.id.memberContentContainer, LoginFragment.newInstance(Member.LOGIN))
                    .commitAllowingStateLoss()
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// TOOLS ///////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun log(s: String) {
        Log.d("RegisterLoginAAAA", s)
    }
}
