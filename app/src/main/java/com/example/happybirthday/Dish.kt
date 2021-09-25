package com.example.happybirthday

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ShareCompat
import com.example.happybirthday.databinding.ActivityDishBinding
import java.text.NumberFormat

class Dish : AppCompatActivity() {

    private lateinit var binding: ActivityDishBinding
    private var amountTotal = 0

    companion object{
        const val TAG = "DishActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDishBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        if(savedInstanceState != null){
            amountTotal = savedInstanceState.getInt("REVENUE", 0)
            var savedValue = savedInstanceState.getInt("REVENUE", 0)
            Log.d(TAG, "Saved value ${savedValue}")

            val formattedNUmber = NumberFormat.getCurrencyInstance().format(amountTotal)
            binding.totalTextView.text = getString(R.string.total_print, formattedNUmber)
        }

        binding.dessertImage.setOnClickListener{
            amountTotal += 5
            val formattedNUmber = NumberFormat.getCurrencyInstance().format(amountTotal)
            binding.totalTextView.text = getString(R.string.total_print, formattedNUmber)
        }

        binding.totalTextView.setOnClickListener{
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "On SaveInstanceState Called.")
        outState.putInt("REVENUE", amountTotal)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"on Start Called.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "on Restart Called.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"On Resume Called.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "On Stop Called.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "On Destroy Called.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "On Pause Called.")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dish_menu, menu)
        val share_button = menu?.findItem(R.id.share_button)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.share_button -> share()
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun share(){
        val shareIntent = ShareCompat.IntentBuilder(this)
            .setText("Total amount: ${amountTotal}")
            .setType("text/plain")
            .intent
        try{
            startActivity(shareIntent)
        }catch(ex: ActivityNotFoundException){
            Toast.makeText(this,"Activity not found.", Toast.LENGTH_SHORT).show()
        }
    }
}
