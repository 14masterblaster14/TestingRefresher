package com.example.test_mockito

//import org.junit.Assert.*
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

// Refer: https://blog.mindorks.com/mockito-cannot-mock-in-kotlin
class OperatorsTest{

    private lateinit var mockOperator : Operators

    @Before
    fun setUp(){
         mockOperator = mock(Operators::class.java)
        `when`(mockOperator.add(3,4)).thenReturn(7)
    }

    @Test
    fun givenValidInput_add_pass(){

        val result = mockOperator.add(3,4)
        assertThat(result).isEqualTo(7)

    }

    // *--  Problem Statement:  --*
    // The test case which we wrote it was correct but the error shows that we can't mock the final class.
    //This is because,
    //All Kotlin Classes are Final by default.

    // *--  Solution 1  --* <Easy and prefered way>
    // Update the below mentioned latest Mockito dependencies and it will work
    // Mockito Framework
        //  testImplementation "org.mockito:mockito-core:2.28.2"

        // testImplementation 'org.mockito:mockito-inline:2.19.0'

    // *--  Solution 2  --* <Old way>
    //create a text file under app/src/test/resources/mockito-extensions called org.mockito.plugins.MockMaker with the following content
    //(it may be easier to switch to the Project view in the Project pane in order to add the new directory and text file):
    // It won't run with Objects
}