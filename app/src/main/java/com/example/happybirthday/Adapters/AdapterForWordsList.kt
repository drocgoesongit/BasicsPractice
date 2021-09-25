package com.example.happybirthday.Adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.view.WindowCallbackWrapper
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.R
import com.example.happybirthday.WordsDetailActivity
import java.net.URI

class AdapterForWordsList(private val context: Context, private val letterId: String): RecyclerView.Adapter<AdapterForWordsList.ViewHolder>(){
    private val filteredWords: List<String>

    init{
        val words = context.resources.getStringArray(R.array.words).toList()

        filteredWords = words
            .filter { it.startsWith(letterId, ignoreCase = true) }
            .shuffled()
            .take(5)
            .sorted()
    }

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.words_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.words_recycler_view_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredWords[position]
        holder.button.text = item

        holder.button.setOnClickListener{
            val context = holder.itemView.context
            val queryUrl: Uri = Uri.parse("${WordsDetailActivity.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return filteredWords.size
    }
}