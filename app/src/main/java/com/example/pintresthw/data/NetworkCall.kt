package com.example.pintresthw.data

import com.google.gson.GsonBuilder
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkCall {
    private val network: INetwork

    companion object {
         private const val BASE_URL = "https://xoosha.com/ws/1/"
    }

    init {
        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        network = retrofit.create(INetwork::class.java)
    }

    fun getRemoteItems(callback: Callback<List<Item>>) {
        network.getData().enqueue(callback)
    }
}