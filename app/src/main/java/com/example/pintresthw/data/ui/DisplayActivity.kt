package com.example.pintresthw.data.ui

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pintresthw.R
import com.example.pintresthw.data.Item
import com.example.pintresthw.data.NetworkCall
import com.example.pintresthw.data.ui.adapter.AdapterDecoration
import com.example.pintresthw.data.ui.adapter.DisplayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayActivity : AppCompatActivity() {
    private val TAG = "PinterestHW"
    private val networkCall = NetworkCall()
    private val callback = object : Callback<List<Item>> {

        override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
            response.isSuccessful.let {
                val list = (response.body()?.toList() ?: emptyList())
                recycler_view.adapter = DisplayAdapter(list)
            }
        }

        override fun onFailure(call: Call<List<Item>>, t: Throwable) {
            Log.e(TAG, "Calling API error: ${t.message}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycler_view.addItemDecoration(AdapterDecoration(20))

        if (isNetworkConnected()) {
            networkCall.getRemoteItems(callback)
        } else {
            AlertDialog.Builder(this).setTitle("No internet connection")
                .setMessage("Please check your internet connection and try again")
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
        }
    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager //1
        val networkInfo = connectivityManager.activeNetworkInfo //2
        return networkInfo != null && networkInfo.isConnected //3
    }

}