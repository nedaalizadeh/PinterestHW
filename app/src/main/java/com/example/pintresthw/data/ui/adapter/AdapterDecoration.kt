package com.example.pintresthw.data.ui.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AdapterDecoration(private val itemspace:Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left=itemspace
        outRect.right=itemspace
        outRect.bottom= itemspace

        if(parent.getChildAdapterPosition(view)==0)
            outRect.top=itemspace
    }
}