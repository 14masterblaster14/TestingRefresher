package com.example.testingrefresher

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

/**
 *  Test Case Format:  SubjectUnderTest_actionOrInput_resultState
 */

class MyCalculationsTest {

    private lateinit var myCalculations: MyCalculations

    @Before
    fun setUp() {
        myCalculations = MyCalculations()
    }

    @Test
    fun calculateCircumference_radiusGiven_returnsCorrectResult() {
        //myCalculations = MyCalculations()
        val result = myCalculations.calculateCircumference(2.1)
        assertThat(result).isEqualTo(13.188)
    }

    @Test
    fun calculateCircumference_zeroRadius_returnsCorrectResult() {
        //myCalculations = MyCalculations()
        val result = myCalculations.calculateCircumference(0.0)
        assertThat(result).isEqualTo(0.0)
    }

    @Test
    fun calculateArea_radiusGiven_returnsCorrectResult() {
        val result = myCalculations.calculateArea(2.1)
        assertThat(result).isEqualTo(13.8474)
    }

    @Test
    fun calculateArea_zeroRadius_returnsCorrectResult() {
        val result = myCalculations.calculateArea(0.0)
        assertThat(result).isEqualTo(0.0)
    }

}