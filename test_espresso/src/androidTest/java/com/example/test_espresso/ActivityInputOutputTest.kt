package com.example.test_espresso

import android.util.Log
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso

import androidx.test.espresso.Espresso.onView

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.action.ViewActions
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.containsString


/**
 * The Two Activities app provides a text entry field and a Send button (the
 * button_main id). Clicking Send launches the Second activity with the entered
 * text shown in the text_header view of the Second activity.
 *
 * The first Espresso test performs a click on the main activity's button, and
 * checks to see if the text_header matches what is displayed. If it passes, it
 * means that the second activity was started. The test then clicks the second
 * activity's button, and checks to see if the text_header_reply matches what is
 * displayed. If it passes, it means that the main activity was started from the
 * second activity.
 *
 * The second test locates the view containing the editText_main view, enters
 * the text "This is a test." and clicks the main button. It then compares the
 * text_message with the assertion "This is a test." If it passes, it means that
 * the entered text was successfully passed to the text_message field.
 */

@RunWith(AndroidJUnit4::class)
class ActivityInputOutputTest {

    //This rule uses an ActivityTestRule object, which provides functional testing of a single Activity—in this case,
    // MainActivity.class. During the duration of the test you will be able to manipulate your Activity directly, using ViewMatchers, ViewActions, and ViewAssertions.
    //@get:Rule
    //val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.example.test_espresso", appContext.packageName)
    }

    @Test
    fun appLaunchesSuccessfully() {
        //activityRule.launchActivity(null)
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun activityLaunch() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button_name))
            .perform(click())
        onView(withId(R.id.text_header)).check(matches(isDisplayed()))
        onView(withId(R.id.button_second))
            .perform(click())

        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()))
    }

    @Test
    fun textInputOutputSuccess() {
        ActivityScenario.launch(MainActivity::class.java)

        // Success Scenario
        onView(withId(R.id.editText_main)).perform(typeText("This is input text."))
        onView(withId(R.id.button_name)).perform(click())
        onView(withId(R.id.text_message)).check(matches(withText("This is input text.")))

        onView(withId(R.id.editText_second)).perform(typeText("This is output text."))
        // ViewActions.closeSoftKeyboard()
        onView(withId(R.id.button_second)).perform(click())
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()))
        onView(withId(R.id.text_message_reply)).check(matches(withText("This is output text.")))
    }

    @Test
    fun textInputOutputFailed() {
        ActivityScenario.launch(MainActivity::class.java)

        // Failed Scenario
        onView(withId(R.id.editText_main)).perform(typeText("This is input text."))
        onView(withId(R.id.button_name)).perform(click())
        onView(withId(R.id.text_message)).check(matches(withText("This is output text.")))
    }

    /**
     * Iterate through the spinner, selecting each item and
     * checking to see if it matches the string in the array.
     */
    @Test
    fun iterateSpinnerItems(){

        ActivityScenario.launch(MainActivity::class.java)
        // Success Scenario
        onView(withId(R.id.editText_main)).perform(typeText("This is input text."))
        onView(withId(R.id.button_name)).perform(click())

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        var myArray = appContext.resources.getStringArray(R.array.labels_array)
        Log.i("MasterBlaster", "myArray size -> ${myArray.size}")

        myArray?.let{

            //var myArray = activityRule.activity.resources.getStringArray(R.array.labels_array)
            Log.i("MasterBlaster", "myArray size -> ${myArray.size}")
            // Iterate through the spinner array of items.
            for (i in 0 until myArray.size) {
                // Find the spinner and click on it.
                onView(withId(R.id.label_spinner)).perform(click())
                // Find the spinner item and click on it.
                onData(
                    `is`(myArray[i]))
                    .perform(click())
                // Find the text view and check that the spinner item is part of the string.
                onView(withId(R.id.text_phonelabel))
                    .check(matches(withText(containsString(myArray[i]))))
            }
        }

    }

}