package com.example.qatrainer.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChallengesPage {

    @AndroidFindBy(id = "com.example.qatrainer:id/tv_timer")
    public WebElement timerText;

    @AndroidFindBy(id = "com.example.qatrainer:id/progress_bar")
    public WebElement progressBar;

    @AndroidFindBy(id = "com.example.qatrainer:id/btn_start")
    public WebElement startButton;

    @AndroidFindBy(id = "com.example.qatrainer:id/btn_green")
    public WebElement greenButton;

    @AndroidFindBy(id = "com.example.qatrainer:id/btn_blue")
    public WebElement blueButton;

    @AndroidFindBy(id = "com.example.qatrainer:id/btn_red")
    public WebElement redButton;

    @AndroidFindBy(id = "com.example.qatrainer:id/tv_completed")
    public WebElement completedText;

    @AndroidFindBy(accessibility = "Countdown timer, seconds remaining")
    public WebElement timerAccessibility;

    public ChallengesPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
