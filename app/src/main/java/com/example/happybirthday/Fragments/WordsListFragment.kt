package com.example.happybirthday.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.happybirthday.Adapters.AdapterForWordsList
import com.example.happybirthday.R
import com.example.happybirthday.RecyclerView
import com.example.happybirthday.databinding.FragmentWordsListBinding

private var _binding: FragmentWordsListBinding? = null
private val binding get() = _binding!!
private lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView
private lateinit var letterId: String

class WordsListFragment: Fragment(){

    companion object {
        val LETTER = "letter"
        val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordsListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.wordsRecyclerView
        recyclerView.adapter = AdapterForWordsList(this.requireContext(), letterId)
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        recyclerView.addItemDecoration(
            DividerItemDecoration(this.requireContext(), DividerItemDecoration.VERTICAL)
        )
    }

}