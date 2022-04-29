package com.example.pintresthw.data

import retrofit2.Call
import retrofit2.http.GET

interface INetwork {

   @GET("test.php?offset=20&sort=crawled_time&order=asc")
    fun getData(): Call<List<Item>>

}