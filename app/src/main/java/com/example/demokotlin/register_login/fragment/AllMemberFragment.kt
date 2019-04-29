package com.example.demokotlin.register_login.fragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.demokotlin.R
import com.example.demokotlin.register_login.MemberDetailActivity
import com.example.demokotlin.register_login.RegisterLoginActivity
import com.example.demokotlin.register_login.adapter.MemberAdapter
import com.example.demokotlin.register_login.model.AllMember
import com.example.demokotlin.register_login.model.Results
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_all_member.*

private const val ALL_MEMBER = "AllMember"

class AllMemberFragment : Fragment(), MemberAdapter.SetItemClickInterface {

    private lateinit var mActivity : RegisterLoginActivity
    private var allMember: AllMember? = null
    private lateinit var mAdapter : MemberAdapter
    private var itemClickInterface : MemberAdapter.SetItemClickInterface = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            allMember = it.getParcelable(ALL_MEMBER)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all_member, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        memberRecyclerView.setHasFixedSize(true)
        memberRecyclerView.layoutManager = LinearLayoutManager(mActivity)
        mAdapter = MemberAdapter(allMember!!, itemClickInterface)
        memberRecyclerView.adapter = mAdapter
    }

    override fun itemClick(results: Results) {
        val intent = Intent(context, MemberDetailActivity::class.java)
        intent.putExtra("results", results)
        startActivity(intent)
    }


    companion object {
        @JvmStatic
        fun newInstance(allMember: AllMember) = AllMemberFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ALL_MEMBER, allMember)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is RegisterLoginActivity)
            mActivity = context
    }

    private fun toastySuccess(s: String) {
        Toasty.success(mActivity, s, Toast.LENGTH_SHORT, true).show()
    }
}
