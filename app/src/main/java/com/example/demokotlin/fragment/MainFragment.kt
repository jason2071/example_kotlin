package com.example.demokotlin.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.demokotlin.model.Product
import com.example.demokotlin.R
import com.example.demokotlin.activity.LayoutActivity
import com.example.demokotlin.fragment.main_demo.MainDemoPresenter
import com.example.demokotlin.fragment.main_demo.MainViewInterface


class MainFragment : Fragment(), MainViewInterface {

    private lateinit var mActivity: LayoutActivity
    private lateinit var mainDemoPresenter: MainDemoPresenter
    private var mainViewInterface: MainViewInterface = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainDemoPresenter = MainDemoPresenter(mActivity, mainViewInterface)
        mainDemoPresenter.validate(1)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment().apply {
            arguments = Bundle().apply {}
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////OVERRIDE INTERFACE///////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onResultProduct(product: Product?) {

        if(product != null) {

            for (i in 0 until product.data.size) {
                val item = product.data[i]

                log("title: ${item.product_name}")
            }

        }
    }

    override fun onReturnView(view: View) {

    }

    override fun onShowFullProgressView() {

    }

    override fun onHideFullProgressView() {

    }

    override fun onDialogNoInternet() {
        toast("No Internet")
    }

    override fun onDialogError(message: String) {
        toast("Error")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is LayoutActivity)
            mActivity = context
    }

    fun toast(s: String) {
        Toast.makeText(mActivity, s, Toast.LENGTH_SHORT).show()
    }

    fun log(s: String) {
        Log.d("LayoutActivityAAA", s)
    }
}
