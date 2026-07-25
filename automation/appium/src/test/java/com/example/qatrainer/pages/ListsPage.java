package com.example.qatrainer.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ListsPage {

    @AndroidFindBy(id = "com.example.qatrainer:id/rv_items")
    public WebElement itemsRecycler;

    @AndroidFindBy(id = "com.example.qatrainer:id/search_view")
    public WebElement searchView;

    @AndroidFindBy(id = "com.example.qatrainer:id/chip_all")
    public WebElement chipAll;

    @AndroidFindBy(id = "com.example.qatrainer:id/chip_favorites")
    public WebElement chipFavorites;

    @AndroidFindBy(id = "com.example.qatrainer:id/chip_active")
    public WebElement chipActive;

    @AndroidFindBy(id = "com.example.qatrainer:id/swipe_refresh")
    public WebElement swipeRefreshLayout;

    @AndroidFindBy(id = "com.example.qatrainer:id/tv_item_title")
    public WebElement firstItemTitle;

    @AndroidFindBy(id = "com.example.qatrainer:id/btn_favorite")
    public WebElement firstFavoriteButton;

    @AndroidFindBy(accessibility = "Pull to refresh list")
    public WebElement swipeRefreshAccessibility;

    public ListsPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
