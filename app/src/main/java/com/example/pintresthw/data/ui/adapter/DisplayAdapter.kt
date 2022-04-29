package com.example.pintresthw.data.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pintresthw.R
import com.example.pintresthw.data.Item
import com.squareup.picasso.Picasso

class DisplayAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<DisplayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DisplayAdapter.ViewHolder, position: Int) {
        val item = itemList[position]
        holder.textView.text = item.name
        Picasso.get().load(item.image_url).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView: TextView = itemView.findViewById(R.id.text_view)
    }
}