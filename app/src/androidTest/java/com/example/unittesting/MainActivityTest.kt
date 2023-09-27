package com.example.unittesting

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    public override fun setUp() {
        println("Start Unit Test")
    }

    @After
    public override fun tearDown() {
        println("End Unit Test")
    }

    @Test
    fun testButtonClick() {

        val dataSets = arrayOf(
            TestData("sahushubham", "sahushubham2208@gmail.com", "#Shubham2208"),
            TestData("anotheruser", "user@example.com", "password123"),
            TestData("user3", "user3@example.com", "secret"),
            TestData("", "sahushubham2208@gmail.com", "#Shubham2208"),
            TestData(
                "sahu", "sahushubham2208@gmail.com", "#Shubham2208"
            ),
            TestData("qwertyuiopasdfghjklzxcvbnm",
                "sahushubham2208@gmail.com",
                "#Shubham2208"),
            TestData("sahushubham", "", "#Shubham2208"),
            TestData("sahushubham", "sahushubham2208", "#Shubham2208"),
            TestData("sahushubham", "@gmail.com", "#Shubham2208"),
            TestData("sahushubham", "invalid-email", "#Shubham2208"),
            TestData("sahushubham", "sahushubham2208@gmail.com", "NoDigitPassword"),
            TestData("sahushubham", "sahushubham2208@gmail.com", ""),
            TestData("sahushubham", "sahushubham2208@gmail.com", "22081998"),
        )

        for (data in dataSets) {
            // Clear the EditText fields
            onView(withId(R.id.eTUserName)).perform(clearText())
            onView(withId(R.id.eTEmail)).perform(clearText())
            onView(withId(R.id.eTPasword)).perform(clearText())

            // Enter the new data
            onView(withId(R.id.eTUserName)).perform(typeText(data.username))
            onView(withId(R.id.eTEmail)).perform(typeText(data.email))
            onView(withId(R.id.eTPasword)).perform(typeText(data.password))
            Espresso.closeSoftKeyboard()
            onView(withId(R.id.btnSubmit)).perform(click())

            // Add assertions here to verify the expected behavior for each data set
        }


    }

    data class TestData(val username: String, val email: String, val password: String)


}