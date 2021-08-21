package com.example.testingrefresher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CalculationsViewModelFactory (
    private val calculations: Calculations
) : ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CalculationsViewModel(calculations) as T
    }
}