package com.example.happybirthday.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.Fragments.LettersListFragmentsDirections
import com.example.happybirthday.R

class WordsAdapter : RecyclerView.Adapter<WordsAdapter.ViewHolder>() {
    val list = ('A').rangeTo('Z').toList()

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.words_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.words_recycler_view_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.button.text = item.toString()

        holder.button.setOnClickListener{
            val action = LettersListFragmentsDirections.actionLettersListFragmentsToWordsListFragment(letter = holder.button.text.toString())
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}