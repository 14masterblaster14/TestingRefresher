package com.example.test_mockito

import org.junit.Assert.*

import org.junit.Test
import java.lang.reflect.Method
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

class GradeCalculatorTest {

    @Test
    fun getGrades() {
    }

    @Test
    fun accessPrivateVariableWithReflection(){
        val gradeCalculator = GradeCalculator()
        val test_variable = GradeCalculator::class.memberProperties.find{it.name == "computeGrade"}
        test_variable?.let {
            it.isAccessible = true
            val actual_value = it
            //val actual_value = it.get(gradeCalculator)
            val expected_value = "I am private variable"

            assertEquals(expected_value, actual_value)
        }
    }

            //.members.find { it.name == "private_variable" }

     //   gradeCalculator::class.members.forEach { member ->
     //       member
     //   }

 //       val test_variable = GradeCalculator::class.get { it.name == "private_variable" }
 //       val test_variable = GradeCalculator::class.members.find { it.name == "computeGrade" }
//        test_variable.
//
//        test_variable?.let {
//            it = true
//        }



    @Test
    fun computeGradeWithReflection()  {

        // With reflection to instantiate an object
        // val gradeCalculator = Class.forName("com.example.test_mockito.GradeCalculator").newInstance()

        // Alternatively you can also use the below:

        val gradeCalculator = GradeCalculator::class.java.newInstance()
        val parameters: Array<Class<*>?> = arrayOfNulls(1)
        parameters[0] = Int::class.java
        //val method: Method = gradeCalculator.javaClass.getDeclaredMethod("computeGrade", *arrayOfNulls(0))
        val methodCall: Method = gradeCalculator.javaClass.getDeclaredMethod("computeGrade", *parameters)
        methodCall.isAccessible=true

        val methodArgument = arrayOfNulls<Any>(1)
        methodArgument[0] = 70

        var actualGrades = methodCall.invoke(gradeCalculator, methodArgument) as String
        val expectedGrade = "1st Division"

        assertEquals(expectedGrade, actualGrades)
    }

    @Test
    fun computeGradeWithPowermock()  {
        val gradeCalculator = GradeCalculator()
        //val actualGrade : String = Whitebox.
    }

    }