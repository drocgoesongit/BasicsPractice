package com.example.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.Adapters.WordsAdapter

class Words : AppCompatActivity() {
    private var isLinearLayoutManager = true;
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)
        title = "Words" // Title of the activity. :D


        //Element initialization.
        recyclerView = findViewById(R.id.words_recyclerView)

        chooseLayout()
    }

    private fun chooseLayout(){
        if(isLinearLayoutManager){
            recyclerView.layoutManager = LinearLayoutManager(this)
        }else{
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        recyclerView.adapter = WordsAdapter()
    }

    private fun setIcon(menuItem: MenuItem?){
        if(menuItem == null)
            return
        menuItem.icon =
            if(isLinearLayoutManager) {
                ContextCompat.getDrawable(this,R.drawable.ic_calendar_view_month_black_24dp)
            }else{
                ContextCompat.getDrawable(this, R.drawable.ic_table_rows_black_24dp)
            }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                // Sets isLinearLayoutManager (a Boolean) to the opposite value
                isLinearLayoutManager = !isLinearLayoutManager
                // Sets layout and icon
                chooseLayout()
                setIcon(item)
                return true
            }

            //  Otherwise, do nothing and use the core event handling
            // when clauses require that all possible paths be accounted for explicitly,
            //  for instance both the true and false cases if the value is a Boolean,
            //  or an else to catch all unhandled cases.
            else -> super.onOptionsItemSelected(item)
        }
    }

    //inflating the menu layout.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        val layout_button = menu?.findItem(R.id.action_switch_layout)
        return true
    }
}