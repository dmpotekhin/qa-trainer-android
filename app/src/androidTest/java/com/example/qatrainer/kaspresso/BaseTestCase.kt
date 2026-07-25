package com.example.qatrainer.kaspresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.qatrainer.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule

open class BaseTestCase : TestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
}
