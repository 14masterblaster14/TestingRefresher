package com.example.test_espresso1

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.test_espresso1.ScreenRobot.Companion.withRobot
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// https://www.raywenderlich.com/949489-espresso-testing-and-screen-robots-getting-started

//ViewMatchers contains methods that Espresso uses to find the view on your screen with which it needs to interact.
//ViewActions contains methods that tell Espresso how to automate your UI. For example, it contains methods like click() that you can use to tell Espresso to click on a button.
//ViewAssertions contains methods used to check if a view matches a certain set of conditions.

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

     @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    // The ActivityScenario class is a part of AndroidX and provides APIs to start and drive an Activity’s lifecycle state for testing.
    @Test
    fun appLaunchesSuccessfully() {
        //activityRule.launchActivity(null)
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun onLaunchCheckAmountInputIsDisplayed() {
       ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.inputAmount))
            .check(matches(isDisplayed()))

    }

    @Test
    fun onLaunchRoundSwitchIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .checkIsDisplayed(R.id.switchRound)
    }

    @Test
    fun onLaunchBadButtonIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withText(R.string.bad))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onLaunchOkayButtonIsDisplayed() {
       ActivityScenario.launch(MainActivity::class.java)

        onView(withText(R.string.okay))
            .check(matches(isDisplayed()))
    }
    // why emoji is treated here as a text. Emoji is just a graphical representation of one or more Unicode
    // characters and Unicode is a standard that assigns a unique identifier to characters, symbols and icons.

    @Test
    fun onLaunchGreatButtonIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withText(R.string.great))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onLaunchTipLabelIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .checkIsDisplayed(R.id.textTipLabel)
    }

    @Test
    fun onLaunchTotalLabelIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .checkIsDisplayed(R.id.textTotal)
    }

    @Test
    fun whenBadButtonIsPressedAndAmountIsEmptyTipIsEmpty() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.buttonBad)
            .verifyTipIsCorrect("")
    }

    @Test
    fun whenBadButtonIsPressedAndAmountIsEmptyTotalIsEmpty() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.buttonBad)
            .verifyTotalIsCorrect("")
    }




    @Test
    fun whenOkayButtonIsPressedAndAmountIsEmptyTipIsEmpty() {
        ActivityScenario.launch(MainActivity::class.java)

       onView(withId(R.id.buttonOkay))
            .perform(click())

        onView(
            allOf(
                withId(R.id.textTip),
                withText("")
            )
        )       // you want the view with the ID textTip and with an empty string as the text
            .check(matches(isDisplayed()))
    }

    // With Robot
    @Test
    fun whenOkayButtonIsPressedAndAmountIsEmptyTipIsEmptyRobot() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.buttonOkay)
            .verifyTipIsCorrect("")
    }

    @Test
    fun whenOkayButtonIsPressedAndAmountIsEmptyTotalIsEmpty() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.buttonOkay)
            .verifyTotalIsCorrect("")
    }

    @Test
    fun whenGreatButtonIsPressedAndAmountIsEmptyTipIsEmpty() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.buttonGreat)
            .verifyTipIsCorrect("")
    }

    @Test
    fun whenGreatButtonIsPressedAndAmountIsEmptyTotalIsEmpty() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.buttonGreat)
            .verifyTotalIsCorrect("")
    }

    @Test
    fun whenBadButtonIsPressedAndAmountIsFilledTipIsSet() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectBadButton("11")
            .verifyTipIsCorrect("1.65")
    }

    @Test
    fun whenBadButtonIsPressedAndAmountIsFilledTotalIsSet() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectBadButton("11")
            .verifyTotalIsCorrect("12.65")
    }

    @Test
    fun whenBadButtonIsPressedAndAmountIsFilledPercentIsSet() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectBadButton("11")
            .verifyPercentIsCorrect("15.00%")
    }


    @Test
    fun whenOkayButtonIsPressedAndAmountIsFilledTipIsSet() {
        ActivityScenario.launch(MainActivity::class.java)

        // 1
        onView(withId(R.id.inputAmount))
            .perform(typeText("11"))

        onView(withId(R.id.buttonOkay))
            .perform(ViewActions.click())

        // 2
        onView(withId(R.id.textTip))
            .check(matches(withText("1.98")))

        //check that the view with the ID textTip has the correct text using withText()
        // instead of combining allOf() and isDisplayed(). This is an alternate way to perform this check.
    }

    // With Robots
    @Test
    fun whenOkayButtonIsPressedAndAmountIsFilledTipIsSetWithRobot() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyTipIsCorrect("1.98")
    }

    @Test
    fun whenOkayButtonIsPressedAndAmountIsFilledTotalIsSet() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyTotalIsCorrect("12.98")
    }

    @Test
    fun whenOkayButtonIsPressedAndAmountIsFilledPercentIsSet() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyPercentIsCorrect("18.00%")
    }

    @Test
    fun whenGreatButtonIsPressedAndAmountIsFilledTipIsSet() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectGreatButton("11")
            .verifyTipIsCorrect("2.20")
    }

    @Test
    fun whenGreatButtonIsPressedAndAmountIsFilledTotalIsSet() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectGreatButton("11")
            .verifyTotalIsCorrect("13.20")
    }

    @Test
    fun whenGreatButtonIsPressedAndAmountIsFilledPercentIsSet() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectGreatButton("11")
            .verifyPercentIsCorrect("20.00%")
    }

    @Test
    fun whenBadButtonIsPressedAndRoundSwitchIsSelectedTipIsCorrect() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.switchRound))
            .perform(ViewActions.click())
        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyTipIsCorrect("2.00")
    }

    @Test
    fun whenBadButtonIsPressedAndRoundSwitchIsSelectedTotalIsCorrect() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.switchRound))
            .perform(ViewActions.click())
        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyTotalIsCorrect("13.00")
    }

    @Test
    fun whenBadButtonIsPressedAndRoundSwitchIsSelectedPercentIsCorrect() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.switchRound))
            .perform(ViewActions.click())
        withRobot(CalculatorScreenRobot::class.java)
            .inputCheckAmountAndSelectBadButton("11")
            .verifyPercentIsCorrect("18.18%")
    }

    @Test
    fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedAmountIsCorrect() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.switchRound))
            .perform(ViewActions.click())
        onView(withId(R.id.inputAmount))
            .perform(typeText("11"))
        onView(withId(R.id.buttonOkay))
            .perform(ViewActions.click())

        onView(withId(R.id.textTip))
            .check(matches(withText("2.00")))
    }

    // Robots
    @Test
    fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedAmountIsCorrectWithRobot() {
       ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.switchRound)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyTipIsCorrect("2.00")
    }

    @Test
    fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedTotalIsCorrect() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.switchRound)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyTotalIsCorrect("13.00")
    }

    @Test
    fun whenOkayButtonIsPressedAndRoundSwitchIsSelectedPercentIsCorrect() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.switchRound)
            .inputCheckAmountAndSelectOkayButton("11")
            .verifyPercentIsCorrect("18.18%")
    }

    @Test
    fun whenGreatButtonIsPressedAndRoundSwitchIsSelectedTipIsCorrect() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.switchRound)
            .inputCheckAmountAndSelectGreatButton("11")
            .verifyTipIsCorrect("3.00")
    }

    @Test
    fun whenGreatButtonIsPressedAndRoundSwitchIsSelectedTotalIsCorrect() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.switchRound)
            .inputCheckAmountAndSelectGreatButton("11")
            .verifyTotalIsCorrect("14.00")
    }

    @Test
    fun whenGreatButtonIsPressedAndRoundSwitchIsSelectedPercentIsCorrect() {
        ActivityScenario.launch(MainActivity::class.java)

        withRobot(CalculatorScreenRobot::class.java)
            .clickOkOnView(R.id.switchRound)
            .inputCheckAmountAndSelectGreatButton("11")
            .verifyPercentIsCorrect("27.27%")

    }
    class CalculatorScreenRobot : ScreenRobot<CalculatorScreenRobot>() {

        fun verifyTipIsCorrect(tip: String): CalculatorScreenRobot {
            return checkViewHasText(R.id.textTip, tip)
        }

        fun verifyTotalIsCorrect(total: String): CalculatorScreenRobot {
            return checkViewHasText(R.id.textTotal, total)
        }

        fun verifyPercentIsCorrect(percent: String): CalculatorScreenRobot {
            return checkViewHasText(R.id.textPercent, percent)
        }

        fun inputCheckAmountAndSelectBadButton(input: String):
                CalculatorScreenRobot {
            return enterTextIntoView(R.id.inputAmount, input)
                .clickOkOnView(R.id.buttonBad)
        }


        fun inputCheckAmountAndSelectOkayButton(input: String):
                CalculatorScreenRobot {
            return enterTextIntoView(R.id.inputAmount, input)
                .clickOkOnView(R.id.buttonOkay)
        }

        fun inputCheckAmountAndSelectGreatButton(input: String):
                CalculatorScreenRobot {
            return enterTextIntoView(R.id.inputAmount, input)
                .clickOkOnView(R.id.buttonGreat)
        }
    }
}