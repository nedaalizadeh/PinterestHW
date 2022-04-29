package com.example.pintresthw.data.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.pintresthw.data.DisplayResult
import com.example.pintresthw.data.NetworkCall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private val TAG = "PinterestHW"
private val networkCall = NetworkCall()

private val callback = object : Callback<DisplayResult> {

    override fun onResponse(call: Call<DisplayResult>, response: Response<DisplayResult>) {
        response.isSuccessful.let {
            val list = DisplayResult(response.body()?.items ?: emptyList())
            Log.d(TAG, "Result is : ${list.items.toString()}")
        }
    }

    override fun onFailure(call: Call<DisplayResult>, t: Throwable) {
        Log.e(TAG, "Calling API error: ${t.message}")
    }

}

class DisplayViewModel : ViewModel() {

}