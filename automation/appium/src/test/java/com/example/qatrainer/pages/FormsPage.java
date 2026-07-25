package com.example.qatrainer.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {

    @AndroidFindBy(id = "com.example.qatrainer:id/et_email")
    public WebElement emailInput;

    @AndroidFindBy(id = "com.example.qatrainer:id/et_password")
    public WebElement passwordInput;

    @AndroidFindBy(id = "com.example.qatrainer:id/btn_submit")
    public WebElement submitButton;

    @AndroidFindBy(id = "com.example.qatrainer:id/btn_clear")
    public WebElement clearButton;

    @AndroidFindBy(id = "com.example.qatrainer:id/tv_error")
    public WebElement errorText;

    @AndroidFindBy(id = "com.example.qatrainer:id/btn_date_picker")
    public WebElement datePickerButton;

    @AndroidFindBy(id = "com.example.qatrainer:id/tv_selected_date")
    public WebElement selectedDateText;

    @AndroidFindBy(id = "com.example.qatrainer:id/sp_country")
    public WebElement countrySpinner;

    public FormsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
