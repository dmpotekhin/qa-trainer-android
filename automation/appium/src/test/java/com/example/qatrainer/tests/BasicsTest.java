package com.example.qatrainer.tests;

import com.example.qatrainer.base.BaseTest;
import com.example.qatrainer.pages.BasicsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicsTest extends BaseTest {

    @Test(priority = 1, description = "Verify welcome text is displayed")
    public void testWelcomeText() {
        BasicsPage page = new BasicsPage(driver);
        Assert.assertTrue(page.welcomeText.isDisplayed(), "Welcome text should be visible");
        Assert.assertEquals(page.welcomeText.getText(), "Welcome to QA Trainer!");
    }

    @Test(priority = 2, description = "Verify welcome text via accessibility ID")
    public void testWelcomeByAccessibility() {
        BasicsPage page = new BasicsPage(driver);
        Assert.assertTrue(page.welcomeByAccessibility.isDisplayed(),
            "Welcome text should be findable by accessibility ID");
    }

    @Test(priority = 3, description = "Toggle notifications switch")
    public void testSwitchToggle() {
        BasicsPage page = new BasicsPage(driver);
        String initialState = page.notificationsSwitch.getAttribute("checked");
        page.notificationsSwitch.click();
        String newState = page.notificationsSwitch.getAttribute("checked");
        Assert.assertNotEquals(initialState, newState, "Switch state should change after click");
    }

    @Test(priority = 4, description = "Show advanced layout when Advanced radio selected")
    public void testAdvancedRadioButton() {
        BasicsPage page = new BasicsPage(driver);
        Assert.assertEquals(page.advancedLayout.getAttribute("displayed"), "false",
            "Advanced layout should be hidden initially");
        page.advancedRadio.click();
        Assert.assertEquals(page.advancedLayout.getAttribute("displayed"), "true",
            "Advanced layout should appear after selecting Advanced");
    }

    @Test(priority = 5, description = "Verify all basics elements have accessibility IDs")
    public void testAccessibilityIds() {
        BasicsPage page = new BasicsPage(driver);
        Assert.assertNotNull(page.welcomeByAccessibility, "Welcome should have accessibility");
        Assert.assertNotNull(page.loginByAccessibility, "Login button should have accessibility");
    }
}
