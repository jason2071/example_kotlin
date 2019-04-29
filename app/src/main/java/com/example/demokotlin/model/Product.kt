package com.example.demokotlin.model

data class Product(
    val current_page: Int,
    val data: ArrayList<Data>,
    val from: Int,
    val last_page: Int,
    val next_page_url: String,
    val path: String,
    val per_page: Int,
    val prev_page_url: String,
    val to: Int,
    val total: Int
)

data class Data(
    val created_at: String,
    val id: Int,
    val product_name: String,
    val product_price: Int,
    val product_qty: Int,
    val updated_at: String
)