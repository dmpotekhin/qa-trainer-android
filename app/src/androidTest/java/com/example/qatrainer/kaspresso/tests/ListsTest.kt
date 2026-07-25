package com.example.qatrainer.kaspresso.tests

import com.example.qatrainer.kaspresso.BaseTestCase
import com.example.qatrainer.kaspresso.screens.ListsScreen
import org.junit.Test

class ListsTest : BaseTestCase() {

    @Test
    fun test_listHasItems() {
        run {
            step("Open Lists tab") {
                device.uiDevice.findObject(
                    androidx.test.uiautomator.UiSelector().text("Lists")
                ).click()
            }
            ListsScreen {
                itemsRecycler.isDisplayed()
                itemsRecycler.childAt<ListsScreen.ListItemType>(0) {
                    title.isDisplayed()
                }
            }
        }
    }

    @Test
    fun test_scrollAndClickItem() {
        run {
            step("Open Lists tab") {
                device.uiDevice.findObject(
                    androidx.test.uiautomator.UiSelector().text("Lists")
                ).click()
            }
            ListsScreen {
                itemsRecycler.scrollTo(position = 10)
                itemsRecycler.childAt<ListsScreen.ListItemType>(10) {
                    title.isDisplayed()
                }
            }
        }
    }

    @Test
    fun test_filterFavorites() {
        run {
            step("Open Lists tab") {
                device.uiDevice.findObject(
                    androidx.test.uiautomator.UiSelector().text("Lists")
                ).click()
            }
            ListsScreen {
                chipFavorites.click()
                // Should show empty or filtered list
                itemsRecycler.isDisplayed()
            }
        }
    }
}
