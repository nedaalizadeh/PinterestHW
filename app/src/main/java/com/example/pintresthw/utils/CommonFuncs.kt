package com.example.pintresthw.utils

import android.content.Context
import android.net.ConnectivityManager


class CommonFuncs {

    fun isNetworkConnected(context:Context):Boolean{
        val connManager =context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val connInfo = connManager.activeNetworkInfo
        return connInfo!= null && connInfo.isConnected
    }
}