package com.example.test_espresso1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test_espresso1.databinding.ActivityMainBinding

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBad.setOnClickListener { calculateTip(BAD_TIP_PERCENTAGE) }
        binding.buttonOkay.setOnClickListener { calculateTip(OKAY_TIP_PERCENTAGE) }
        binding.buttonGreat.setOnClickListener { calculateTip(GREAT_TIP_PERCENTAGE) }
    }
    private fun calculateTip(percentage: Double) {
        binding.inputAmount.text?.toString()?.let { bill ->
            if (bill.isNotEmpty()) {
                val billTotal = bill.toDouble()
                var tip = billTotal * percentage
                if (binding.switchRound.isChecked) {
                    val additionalTip = Math.ceil(tip + billTotal) - (tip + billTotal)
                    tip += additionalTip
                }
                showResult(tip, tip + billTotal, tip / billTotal * 100)
            }
        }
    }

    private fun showResult(tip: Double, total: Double, percentage: Double) {
        binding.textTip.text = String.format("%.2f", tip)
        binding.textTotal.text = String.format("%.2f", total)
        binding.textPercent.text = String.format("%.2f", percentage) + "%"
    }

    companion object {
        const val BAD_TIP_PERCENTAGE = 0.15
        const val OKAY_TIP_PERCENTAGE = 0.18
        const val GREAT_TIP_PERCENTAGE = 0.20
    }
}