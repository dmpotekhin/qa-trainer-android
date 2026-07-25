package com.example.qatrainer.kaspresso.tests

import com.example.qatrainer.kaspresso.BaseTestCase
import com.example.qatrainer.kaspresso.screens.FormsScreen
import org.junit.Test

class FormsTest : BaseTestCase() {

    @Test
    fun test_submitDisabledInitially() {
        run {
            step("Open Forms tab") {
                device.uiDevice.findObject(
                    androidx.test.uiautomator.UiSelector().text("Forms")
                ).click()
            }
            FormsScreen {
                submitButton.isNotEnabled()
            }
        }
    }

    @Test
    fun test_emailValidationError() {
        run {
            step("Open Forms tab") {
                device.uiDevice.findObject(
                    androidx.test.uiautomator.UiSelector().text("Forms")
                ).click()
            }
            FormsScreen {
                emailInput.typeText("invalid")
                errorText.isDisplayed()
                errorText.hasText("Please enter a valid email")
            }
        }
    }

    @Test
    fun test_passwordValidationError() {
        run {
            step("Open Forms tab") {
                device.uiDevice.findObject(
                    androidx.test.uiautomator.UiSelector().text("Forms")
                ).click()
            }
            FormsScreen {
                emailInput.typeText("valid@test.com")
                passwordInput.typeText("123")
                errorText.isDisplayed()
                errorText.hasText("Password must be > 6 characters")
            }
        }
    }

    @Test
    fun test_clearButtonResetsForm() {
        run {
            step("Open Forms tab") {
                device.uiDevice.findObject(
                    androidx.test.uiautomator.UiSelector().text("Forms")
                ).click()
            }
            FormsScreen {
                emailInput.typeText("test@example.com")
                passwordInput.typeText("password123")
                clearButton.click()
                emailInput.hasEmptyText()
                passwordInput.hasEmptyText()
            }
        }
    }
}
