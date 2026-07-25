package com.example.qatrainer.tests;

import com.example.qatrainer.base.BaseTest;
import com.example.qatrainer.pages.FormsPage;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormsTest extends BaseTest {

    @Test(priority = 1, description = "Submit button disabled without valid input")
    public void testSubmitDisabledInitially() {
        // Navigate to Forms tab
        driver.findElement(
            io.appium.java_client.AppiumBy.accessibilityId("Forms")
        ).click();

        FormsPage page = new FormsPage(driver);
        Assert.assertFalse(page.submitButton.isEnabled(),
            "Submit button should be disabled initially");
    }

    @Test(priority = 2, description = "Fill email and validate error message")
    public void testEmailValidation() {
        driver.findElement(
            io.appium.java_client.AppiumBy.accessibilityId("Forms")
        ).click();

        FormsPage page = new FormsPage(driver);
        page.emailInput.sendKeys("invalid-email");
        Assert.assertTrue(page.errorText.isDisplayed(),
            "Error message should be displayed for invalid email");
    }

    @Test(priority = 3, description = "Select date from DatePicker")
    public void testDatePicker() {
        driver.findElement(
            io.appium.java_client.AppiumBy.accessibilityId("Forms")
        ).click();

        FormsPage page = new FormsPage(driver);
        page.datePickerButton.click();

        // Click OK on the DatePicker dialog
        driver.findElement(
            io.appium.java_client.AppiumBy.id("android:id/button1")
        ).click();

        String date = page.selectedDateText.getText();
        Assert.assertNotEquals(date, "No date selected",
            "Selected date should update after DatePicker");
    }
}
