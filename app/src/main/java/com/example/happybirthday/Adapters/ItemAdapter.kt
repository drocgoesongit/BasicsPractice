package com.example.happybirthday.Adapters

import android.content.Context
import com.example.happybirthday.Model.Affirmation
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.happybirthday.R
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(var dataList: List<Affirmation>, var context: Context) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.layout_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageId)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }
}