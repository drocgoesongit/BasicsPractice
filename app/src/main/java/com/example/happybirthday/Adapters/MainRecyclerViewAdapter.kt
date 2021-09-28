package com.example.happybirthday.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.*
import com.example.happybirthday.Model.DataSource

class MainRecyclerViewAdapter : RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {

    val dataList = DataSource().loadActivityName()

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val activityName = itemView.findViewById<TextView>(R.id.name_of_activity)
        val acitiityNumber = itemView.findViewById<TextView>(R.id.number_of_activity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_recyclerview_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        val context = holder.itemView.context
        holder.activityName.text = item.activityName
        holder.acitiityNumber.text = item.activityNumber.toString()

        holder.itemView.setOnClickListener {
            if (item.activityNumber == 1) {
                val intent = Intent(context, TipCounterActivity::class.java)
                context.startActivity(intent)
            } else if (item.activityNumber == 2) {
                val intent = Intent(context, DiceJava::class.java)
                context.startActivity(intent)
            } else if (item.activityNumber == 3) {
                val intent = Intent(context, DiceClass::class.java)
                context.startActivity(intent)
            }  else if (item.activityNumber == 4) {
                val intent = Intent(context, Dish::class.java)
                context.startActivity(intent)
            } else if (item.activityNumber == 5) {
                val intent = Intent(context, com.example.happybirthday.RecyclerView::class.java)
                context.startActivity(intent)
            }else if (item.activityNumber == 6) {
                val intent = Intent(context, FragmentHolder::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}