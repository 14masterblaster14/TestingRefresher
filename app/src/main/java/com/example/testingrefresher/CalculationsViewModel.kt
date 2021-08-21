package com.example.testingrefresher

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *  Testing with Mocks by Mockito framework
 *
 *  Here we are using Calculations interface as a constructor argument.
 *  We will use Mockito framework to generate mock Calculations instance.
 */
class CalculationsViewModel (
    private val calculations: Calculations
) : ViewModel() {

    var radius = MutableLiveData<String>()

    var area = MutableLiveData<String?>()
    val areaValue: LiveData<String?>
        get() = area

    var circumference = MutableLiveData<String?>()
    val circumferenceValue: LiveData<String?>
        get() = circumference


    fun calculate() {

        try {

            val radiusDoubleValue = radius.value?.toDouble()
            if (radiusDoubleValue != null) {
                calculateArea(radiusDoubleValue)
                calculateCircumference(radiusDoubleValue)
            } else {
                area.value = null
                circumference.value = null
            }

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
            area.value = null
            circumference.value = null
        }

    }

    fun calculateArea(radius: Double) {
        val calculatedArea = calculations.calculateArea(radius)
        area.value = calculatedArea.toString()
    }

    fun calculateCircumference(radius: Double) {
        val calculatedCircumference = calculations.calculateCircumference(radius)
        circumference.value = calculatedCircumference.toString()
    }

}