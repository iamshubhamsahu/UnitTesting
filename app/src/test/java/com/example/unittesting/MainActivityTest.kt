package com.example.unittesting

import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {


    @Before
    fun setUp() {
        println("Start Unit Test")
    }

    @After
    fun tearDown() {
        println("End Unit Test")
    }


    @Test
    fun username_is_empty() {
        println("-> username_is_empty()")
        val userName = ""
        val assert = Validator.validate(userName, "sahushubham2208@gmail.com", "#Shubham2208")
        assert(assert == "Plz enter username")
    }

    @Test
    fun username_length_less_than_6() {
        println("-> username_length_less_than_6()")
        val userName = "sahu"
        assert(
            Validator.validate(
                userName,
                "sahushubham2208@gmail.com",
                "#Shubham2208"
            ) == "very short username"
        )
    }

    @Test
    fun username_lenght_very_long() {
        println("-> username_lenght_very_long()")
        val userName = "qwertyuiopasdfghjklzxcvbnm"
        assert(
            Validator.validate(
                userName,
                "sahushubham2208@gmail.com",
                "#Shubham2208"
            ) == "very long username"
        )
    }

    @Test
    fun email_is_empty() {
        println("-> email_is_empty()")
        val email = ""
        val assert = Validator.validate("sahushubham", email, "#Shubham2208")
        assert(assert == "Plz enter email")
    }

    @Test
    fun email_is_invalid() {
        println("-> email_is_invalid()")
        val email = "invalid-email"
        val assert = Validator.validate("sahushubham", email, "#Shubham2208")
        assert(assert == "plz enter valid email")
    }

    @Test
    fun password_without_digit() {
        println("-> password_without_digit()")
        val password = "NoDigitPassword"
        val assert = Validator.validate("sahushubham", "sahushubham2208@gmail.com", password)
        assert(assert == "password must contain at least one digit")
    }
}