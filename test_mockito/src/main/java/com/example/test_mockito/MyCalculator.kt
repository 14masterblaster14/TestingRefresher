package com.example.test_mockito

class MyCalculator(private val operators:Operators) {

    fun addTwoNumbers(ab: Int, ba: Int): Int = operators.add(ab, ba)
    fun subtractTwoNumbers(ac: Int, bc: Int): Int = operators.subtract(ac, bc)
    fun multiplyTwoNumbers(ad: Int, bd: Int): Int = operators.multiply(ad, bd)
    fun divideTwoNumbers(aa: Int, ba: Int): Int = operators.divide(aa, ba)
}