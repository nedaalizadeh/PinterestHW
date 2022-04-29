package com.example.pintresthw.data

data class DisplayResult(val items: List<Item>)

data class Item(
    val page_id: String?,
    val url: String?,
    val image_url: String?,
    val price: String?,
    val name: String?,
    val crawled_time: String?,
    val created_time: String?,
    val width: String?,
    val height: String?,
    val description: String?,
    val brand: String?,
    val price_updated: String?,
    val last_update: String?,
    val currency: String?,
    val discount: String?
)
