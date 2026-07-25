package com.example.qatrainer.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;

public abstract class BaseTest {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
            .setPlatformName("Android")
            .setAutomationName("UiAutomator2")
            .setApp(System.getProperty("app.path", "../app/qa-trainer.apk"))
            .setNoReset(true)
            .setAutoGrantPermissions(true)
            .setAppWaitActivity("com.example.qatrainer.MainActivity");

        driver = new AndroidDriver(
            new URL(System.getProperty("appium.url", "http://127.0.0.1:4723")),
            options
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
