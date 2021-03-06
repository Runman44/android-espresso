package com.example.android.testing.espresso.basicSample


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Test2Test {

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
            MainActivity::class.java)

    @Test
    fun test2_newActivity_list_error() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(typeText("Espresso"),
                closeSoftKeyboard())
        onView(withId(R.id.test2)).perform(click())

        // Error on this line ! but why ?
        onView(withText("test")).check(matches(isDisplayed()))
    }

    @Test
    fun test2_newActivity_list_error2() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(typeText("Espresso"),
                closeSoftKeyboard())
        onView(withId(R.id.test2)).perform(click())

        // Error on this line ! but why ?
        onView(withId(R.id.text_test)).check(matches(withText("test")))
    }

    @Test
    fun test2_newActivity_list_passed() {
        onView(withId(R.id.test2)).perform(click())

        onView(allOf(withId(R.id.text_test), withText("testing"))).check(matches(isDisplayed()))
    }
}