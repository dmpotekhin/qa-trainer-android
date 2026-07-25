package com.example.qatrainer.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasicsPage {

    @AndroidFindBy(id = "com.example.qatrainer:id/tv_welcome")
    public WebElement welcomeText;

    @AndroidFindBy(id = "com.example.qatrainer:id/btn_login")
    public WebElement loginButton;

    @AndroidFindBy(id = "com.example.qatrainer:id/sw_notifications")
    public WebElement notificationsSwitch;

    @AndroidFindBy(id = "com.example.qatrainer:id/cb_terms")
    public WebElement termsCheckbox;

    @AndroidFindBy(id = "com.example.qatrainer:id/rg_level")
    public WebElement levelRadioGroup;

    @AndroidFindBy(id = "com.example.qatrainer:id/rb_beginner")
    public WebElement beginnerRadio;

    @AndroidFindBy(id = "com.example.qatrainer:id/rb_intermediate")
    public WebElement intermediateRadio;

    @AndroidFindBy(id = "com.example.qatrainer:id/rb_advanced")
    public WebElement advancedRadio;

    @AndroidFindBy(id = "com.example.qatrainer:id/iv_logo")
    public WebElement logoImage;

    @AndroidFindBy(id = "com.example.qatrainer:id/layout_advanced_hidden")
    public WebElement advancedLayout;

    @AndroidFindBy(accessibility = "Welcome message")
    public WebElement welcomeByAccessibility;

    @AndroidFindBy(accessibility = "Login button")
    public WebElement loginByAccessibility;

    public BasicsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
