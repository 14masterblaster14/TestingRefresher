package com.example.testjunit

//import org.junit.Assert.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.Assert.*


/**
 * The test cases will pass if..
 * ...username/password/confirmPassword is not empty
 * ...password is at least 2 digits
 * ...password matches the confirm Password
 * ...username is not taken
 */

class RegistrationUtilTest{

    // Write tests for the RegistrationUtil class considering all the conditions
    // annotate each function with @Test
    // We can use backtick to write function name..
    // whatever we write in those backtick will be considered as function name
    @Test
    fun `empty username returns false`(){
        // Pass the value to the function of RegistrationUtil class
        // since RegistrationUtil is an object/ singleton we do not need to create its object
        val result = RegistrationUtil.validRegistrationInput(
            "",
            "123",
            "123"
        )

        // JUnit way
        assertFalse(result)
        // Truth way
        // assertThat() comes from the truth library that we added earlier
        // put result in it and assign the boolean that it should return
        assertThat(result).isFalse()
    }

    // follow the same for other cases also
    // in this test if username and correctly repeated password returns true
    @Test
    fun `username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validRegistrationInput(
            "Rahul",
            "123",
            "123"
        )
        // JUnit way
        assertTrue(result)
        // Truth way
        assertThat(result).isTrue()
    }

    // in this test serName already taken returns false
    @Test
    fun `username already taken returns false`() {
        val result = RegistrationUtil.validRegistrationInput(
            "Rohan",
            "123",
            "123"
        )
        // JUnit way
        assertFalse(result)
        // Truth way
        assertThat(result).isFalse()
    }

    // if confirm password does nt matches the password return false
    @Test
    fun `incorrect confirm password returns false`() {
        val result = RegistrationUtil.validRegistrationInput(
            "Rahul",
            "123",
            "1234"
        )
        // JUnit way
        assertFalse(result)
        // Truth way
        assertThat(result).isFalse()
    }

    // in this test if password has less than two digits than return false
    @Test
    fun `less than two digit password return false`() {
        val result = RegistrationUtil.validRegistrationInput(
            "Rahul",
            "abcd1",
            "abcd1"
        )
        // JUnit way
        assertFalse(result)
        // Truth way
        assertThat(result).isFalse()
    }


}