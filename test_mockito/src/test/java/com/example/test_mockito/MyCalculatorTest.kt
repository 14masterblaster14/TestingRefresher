package com.example.test_mockito

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class) //   it offers a Runner to run the test.
class MyCalculatorTest {

    @Mock
    lateinit var operators:Operators
    lateinit var myCalculator: MyCalculator

    @Before
    fun someSetup(){
        myCalculator = MyCalculator(operators)
    }

    @Test
    fun givenValidInput_whenAdd_shouldCallAddOperator() {
        val aa = 11
        val ba = 21
        myCalculator.addTwoNumbers(aa, ba)
        verify(operators).add(aa, ba)       // want to check if a certain method of a mock object has been called or not.
                                            //  Success
        verify(operators).subtract(aa, ba)  //  Failed
    }

    @Test
    fun givenValidInput_whenSubtract_shouldCallSubtractOperator() {
        val ac = 11
        val bc = 21
        myCalculator.subtractTwoNumbers(ac, bc)
        verify(operators).subtract(ac, bc)
    }

    @Test
    fun givenValidInput_whenMultiply_shouldCallMultiplyOperator() {
        val av = 11
        val bv = 21
        myCalculator.multiplyTwoNumbers(av, bv)
        verify(operators).multiply(av, bv)
    }

    @Test
    fun givenValidInput_whenDivide_shouldCallDivideOperator() {
        val ap = 11
        val bp = 21
        myCalculator.divideTwoNumbers(ap, bp)
        verify(operators).divide(ap, bp)
    }

}