package com.example.testingrefresher

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito



/**
 *   View Model and Live data testing with Mocks with Mockito framework
 *
 */


class CalculationsViewModelTest{

    private lateinit var calculationsViewModel: CalculationsViewModel
    private lateinit var calculations: Calculations

    // As we are testing live data, we need to add InstantTaskExecutorRule.
    // It will run architecture related background jobs in the same thread so that the test results happens synchronously
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        calculations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)
        calculationsViewModel = CalculationsViewModel(calculations)
    }

    @Test
    fun calculateArea_radiusSent_updateLiveData(){
        calculationsViewModel.calculateArea(2.1)
        val result = calculationsViewModel.areaValue.value
        assertThat(result).isEqualTo("13.8474")
    }

    @Test
    fun calculateCircumference_radiusSent_updateLiveData(){
        calculationsViewModel.calculateCircumference(1.0)
        val result = calculationsViewModel.circumferenceValue.value
        assertThat(result).isEqualTo("6.28")
    }
}