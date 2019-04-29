package com.example.demokotlin.fragment.main_demo

import com.example.demokotlin.BaseItemViewInterface
import com.example.demokotlin.model.Product

interface MainViewInterface: BaseItemViewInterface {
    fun onResultProduct(product: Product?)
}