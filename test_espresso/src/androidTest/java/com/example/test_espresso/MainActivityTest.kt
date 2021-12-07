package com.example.test_espresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * To test annotations:

@RunWith(AndroidJUnit4.class): Create an instrumented JUnit 4 test class.
@Rule: Add or redefine the behavior of each test method in a reusable way, using one of the test rule classes that the Android Testing Support Library provides, such as ActivityTestRule or ServiceTestRule.
@Test: The @Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
To test code:

ViewMatchers class lets you find a view in the current View hierarchy so that you can examine something or perform an action.
ViewActions class lets you perform an action on a view found by a ViewMatcher.
ViewAssertions class lets you assert or check the state of a view found by a ViewMatcher.
To test a spinner:

Use onData() with a View that is dynamically populated by an adapter at runtime.
Get items from an app's array by establishing the context with getActivity() and getting a resources instance using getResources().
Use onData() to find and click each spinner item.
Use onView() with a ViewAction and ViewAssertion to check if the output matches the selected spinner item.

 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    //  rule specifies that we are running test on MainActivity
//    @Rule // Add or redefine the behavior of each test method in a reusable way, using one of the test rule classes that the Android Testing Support Library provides, such as ActivityTestRule or ServiceTestRule.
//    var activityScenarioRule: ActivityScenarioRule<MainActivity?>? = ActivityScenarioRule(
//        MainActivity::class.java
//    )


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun appLaunchesSuccessfully() {
        //activityRule.launchActivity(null)
        ActivityScenario.launch(MainActivity::class.java)
    }

    // test to check if the preferred language of user is displayed under the chosen language or not
    @Test
    fun selectLanguageAndCheck() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(ViewMatchers.withId(R.id.german)) // ViewMatchers - withId(R.id.german) is to specify that we are looking for Button with id = R.id.german
            .perform(ViewActions.click())       // ViewActions - Performs click action on view.
        onView(ViewMatchers.withId(R.id.preferred_language)) // ViewMatchers - withId(R.id.preferred_language)
            // is to specify that we are looking for a TextView
            // with id = R.id.preferred_language
            .check(ViewAssertions.matches(ViewMatchers.withText("German")))     // ViewAssertions - validates if preferred_language
        // matches with the text "German" since we
        // pressed german language button.
    }

}