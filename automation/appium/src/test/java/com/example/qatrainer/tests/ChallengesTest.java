package com.example.qatrainer.tests;

import com.example.qatrainer.base.BaseTest;
import com.example.qatrainer.pages.ChallengesPage;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengesTest extends BaseTest {

    @Test(priority = 1, description = "Complete full challenge flow")
    public void testFullChallengeFlow() {
        driver.findElement(AppiumBy.accessibilityId("Challenges")).click();

        ChallengesPage page = new ChallengesPage(driver);

        // Verify timer
        Assert.assertEquals(page.timerText.getText(), "30",
            "Timer should start at 30");

        // Click Start
        page.startButton.click();

        // Handle dialog - click "Yes"
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        // Wait a moment for buttons to appear
        try { Thread.sleep(500); } catch (InterruptedException e) {}

        // Press in correct order: Green → Blue → Red
        page.greenButton.click();
        page.blueButton.click();
        page.redButton.click();

        // Verify completion
        Assert.assertTrue(page.completedText.isDisplayed(),
            "Completed text should appear after pressing buttons in order");
        Assert.assertEquals(page.completedText.getText(), "Completed!");
    }

    @Test(priority = 2, description = "Verify timer accessibility ID")
    public void testTimerAccessibility() {
        driver.findElement(AppiumBy.accessibilityId("Challenges")).click();

        ChallengesPage page = new ChallengesPage(driver);
        Assert.assertNotNull(page.timerAccessibility,
            "Timer should have accessibility ID for Appium");
    }
}
