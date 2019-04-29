package com.example.demokotlin.register_login.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.demokotlin.R
import com.example.demokotlin.register_login.RegisterLoginActivity
import com.example.demokotlin.register_login.common.Member
import com.example.demokotlin.register_login.model.BaseResponse
import com.example.demokotlin.register_login.model.PassParameterModel
import com.example.demokotlin.register_login.presenter.UserPresenter
import com.example.demokotlin.register_login.presenter.UserViewInterface
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_login.*

private const val MEMBER = "Member"

class LoginFragment : Fragment(), UserViewInterface {

    private lateinit var mActivity : RegisterLoginActivity
    private lateinit var loginType: Member
    private lateinit var userPresenter: UserPresenter
    private var userViewInterface: UserViewInterface = this

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userPresenter = UserPresenter(userViewInterface)

        when (loginType) {
            Member.REGISTER -> {
                btnAction.apply {
                    text = "Register"
                    setOnClickListener {

                        if (editName.length() <= 0) {
                            toastyInfo("Please insert the correct name")
                            return@setOnClickListener
                        }

                        if (editEmail.length() <= 0) {
                            toastyInfo("Please insert the correct email")
                            return@setOnClickListener
                        }

                        if (!isEmailValid(editEmail.text.toString())) {
                            toastyInfo("Invalid email format")
                            return@setOnClickListener
                        }

                        if (editPassword.length() <= 0) {
                            toastyInfo("Please insert the correct password")
                            return@setOnClickListener
                        }

                        userPresenter.validateRegister(
                            PassParameterModel(
                                editName.text.toString(),
                                editEmail.text.toString(),
                                editPassword.text.toString()
                            )
                        )
                    }

                }
            }
            Member.LOGIN -> {
                editName.visibility = View.GONE
                btnAction.apply {
                    text = "Login"
                    setOnClickListener {
                        if (editEmail.length() <= 0) {
                            toastyInfo("Please insert the correct email")
                            return@setOnClickListener
                        }

                        if (!isEmailValid(editEmail.text.toString())) {
                            toastyInfo("Invalid email format")
                            return@setOnClickListener
                        }

                        if (editPassword.length() <= 0) {
                            toastyInfo("Please insert the correct password")
                            return@setOnClickListener
                        }

                        userPresenter.validateLogin(
                            PassParameterModel(
                                "",
                                editEmail.text.toString(),
                                editPassword.text.toString()
                            )
                        )
                    }
                }
            }
            else -> { log("no loginType") }
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////// OVERRIDE INTERFACE ///////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onSuccess(data: Any?) {
        when (loginType) {
            Member.LOGIN -> {
                data as BaseResponse
                if (data.status)
                    toastySuccess("${data.message}, user_hash: ${data.results!!.user_hash}")
                else
                    toastyError(data.message!!)
            }
            Member.REGISTER -> {
                data as BaseResponse
                if (data.status)
                    toastySuccess("${data.message}, user_hash: ${data.results!!.user_hash}")
                else
                    toastyError(data.message!!)
            }
            else -> { log("no loginType") }
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
        log("onDialogError: $message")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is RegisterLoginActivity)
            mActivity = context
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////// CREATE /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            loginType = it.getSerializable(MEMBER) as Member
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(type: Member) = LoginFragment().apply {
            arguments = Bundle().apply {
                putSerializable(MEMBER, type)
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////// TOOLS /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun toastySuccess(s: String) {
        Toasty.success(mActivity, s, Toast.LENGTH_SHORT, true).show()
    }

    private fun toastyError(s: String) {
        Toasty.error(mActivity, s, Toast.LENGTH_SHORT, true).show()
    }

    private fun toastyInfo(s: String) {
        Toasty.info(mActivity, s, Toast.LENGTH_SHORT, true).show()
    }

    private fun log(s: String) {
        Log.d("RegisterLoginAAAA", s)
    }
}
