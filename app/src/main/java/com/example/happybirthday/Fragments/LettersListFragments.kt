package com.example.happybirthday.Fragments

import android.os.Bundle
import android.os.RecoverySystem
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.Adapters.WordsAdapter
import com.example.happybirthday.R
import com.example.happybirthday.databinding.FragmentLettersListFragmentsBinding

private var _binding: FragmentLettersListFragmentsBinding? = null
private val binding get() = _binding!!
private lateinit var recyclerView: RecyclerView
private var isLinearLayoutManager = true

class LettersListFragments: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLettersListFragmentsBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView = binding.lettersRecyclerView
        chooseLayout()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    private fun setIcon(layoutButton: MenuItem?) {
        if (layoutButton == null){
            return
        }
        else{
            layoutButton.icon =
                if(isLinearLayoutManager) {
                    ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_calendar_view_month_black_24dp)
                }else{
                    ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_table_rows_black_24dp)
                }
        }
    }

    private fun chooseLayout() {
        when(isLinearLayoutManager){
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
                recyclerView.adapter = WordsAdapter()
            }
            false -> {
                recyclerView.layoutManager = GridLayoutManager(this.requireContext(), 4)
                recyclerView.adapter = WordsAdapter()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}

