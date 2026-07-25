package com.example.qatrainer.kaspresso.tests

import com.example.qatrainer.kaspresso.BaseTestCase
import com.example.qatrainer.kaspresso.screens.ChallengesScreen
import com.kaspersky.kaspresso.flakysafety.FlakySafetyParams
import com.kaspersky.kaspresso.flakysafety.flakySafely
import org.junit.Test

class ChallengesTest : BaseTestCase() {

    @Test
    fun test_completeChallengeFlow() {
        run {
            step("Open Challenges tab") {
                device.uiDevice.findObject(
                    androidx.test.uiautomator.UiSelector().text("Challenges")
                ).click()
            }

            ChallengesScreen {
                step("Start challenge") {
                    startButton.isDisplayed()
                    startButton.click()
                }

                step("Handle Ready dialog") {
                    // Click "Yes" on dialog
                    device.uiDevice.findObject(
                        androidx.test.uiautomator.UiSelector().text("Yes")
                    ).click()
                }

                step("Press buttons in correct order: Green → Blue → Red") {
                    greenButton.click()
                    blueButton.click()
                    redButton.click()
                }

                step("Verify completion") {
                    flakySafely(FlakySafetyParams(timeoutMs = 3000, intervalMs = 500)) {
                        completedText.isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun test_timerIsDisplayed() {
        run {
            step("Open Challenges tab") {
                device.uiDevice.findObject(
                    androidx.test.uiautomator.UiSelector().text("Challenges")
                ).click()
            }
            ChallengesScreen {
                timerText.isDisplayed()
                timerText.hasText("30")
                progressBar.isDisplayed()
            }
        }
    }
}
