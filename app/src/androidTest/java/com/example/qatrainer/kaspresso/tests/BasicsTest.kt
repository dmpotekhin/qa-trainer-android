package com.example.qatrainer.kaspresso.tests

import com.example.qatrainer.kaspresso.BaseTestCase
import com.example.qatrainer.kaspresso.screens.BasicsScreen
import org.junit.Test

class BasicsTest : BaseTestCase() {

    @Test
    fun test_allElementsDisplayed() {
        run {
            BasicsScreen {
                welcomeText.isDisplayed()
                loginButton.isDisplayed()
                notificationsSwitch.isDisplayed()
                termsCheckbox.isDisplayed()
                logoImage.isDisplayed()
                levelRadioGroup.isDisplayed()
                beginnerRadio.isDisplayed()
                advancedRadio.isDisplayed()
            }
        }
    }

    @Test
    fun test_radioGroupShowsAdvancedLayout() {
        run {
            BasicsScreen {
                advancedLayout.isNotDisplayed()
                advancedRadio.click()
                advancedLayout.isDisplayed()
                advancedInfoText.isDisplayed()
                beginnerRadio.click()
                advancedLayout.isNotDisplayed()
            }
        }
    }

    @Test
    fun test_loginButtonClickable() {
        run {
            BasicsScreen {
                loginButton.isClickable()
                loginButton.click()
            }
        }
    }

    @Test
    fun test_switchToggle() {
        run {
            BasicsScreen {
                notificationsSwitch.isChecked()
                notificationsSwitch.setChecked(false)
                notificationsSwitch.isNotChecked()
                notificationsSwitch.setChecked(true)
                notificationsSwitch.isChecked()
            }
        }
    }
}
