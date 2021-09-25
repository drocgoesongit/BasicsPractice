@file:Suppress("Annotator")

package com.example.happybirthday

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthday.databinding.ActivityTipCounterBinding
import java.lang.Math.ceil
import java.text.NumberFormat

class TipCounterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipCounterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.calculateButton.setOnClickListener {
            val tip = calculate()
            val formattedNumber = NumberFormat.getCurrencyInstance().format(tip)
            binding.result.text = getString(R.string.result, formattedNumber)
        }
        binding.tipAmoun.setOnKeyListener{view, keyCode, _ -> handelKeyEvent(view , keyCode)}
    }

    //Method to hide "keyboard"  on pressing "Enter" key. :D
    private fun handelKeyEvent(view : View, keyCode : Int ): Boolean{
        if(keyCode == KeyEvent.KEYCODE_ENTER){
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
            return true
        }
        return false
    }

    private fun calculate(): Double {
        val amount: String = binding.tipAmount.text.toString()
        val amountDouble = amount.toDoubleOrNull() // Converting the string number to double.
        //Handling nullability of the input. :D
        if(amountDouble == null){
            Toast.makeText(this, amount, Toast.LENGTH_SHORT).show()
            return 0.0
        }

        val percentage = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.amazingRadioButton -> 20
            R.id.okRadioButton -> 15
            else -> 18
        }
        var tipAmount = (amountDouble * percentage) / 100
        if (binding.roundUpSwitch.isChecked) {
            tipAmount = kotlin.math.ceil(tipAmount)
        }
        Toast.makeText(this, tipAmount.toString(), Toast.LENGTH_SHORT).show()
        return tipAmount
    }
}