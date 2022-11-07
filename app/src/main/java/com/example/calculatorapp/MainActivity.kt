package com.example.calculatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorapp.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip () }
    }
// Get cost of service
private fun calculateTip() {
       val cost = binding.serviceCostInput.text.toString().toDoubleOrNull()


    //check if null
    if (cost == null){
        binding.tipResult.text = ""
        return
    }
    //get tip percentage from radio group
        val tipPercentage = when (binding.ratings.checkedRadioButtonId) {
        R.id.amazing_rating -> 0.20
        R.id.good_rating -> -0.18
        else -> 0.15
    }

    var tip = tipPercentage * cost


    if (binding.roundingOffSwitch.isChecked){
        tip = ceil(tip)
    }

    val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
    binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

    }




}
