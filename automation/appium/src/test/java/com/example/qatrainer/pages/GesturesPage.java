package com.example.qatrainer.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GesturesPage {

    @AndroidFindBy(id = "com.example.qatrainer:id/vp_gesture_pages")
    public WebElement viewPager;

    @AndroidFindBy(id = "com.example.qatrainer:id/rv_carousel")
    public WebElement carouselRecycler;

    @AndroidFindBy(id = "com.example.qatrainer:id/rv_drag")
    public WebElement dragRecycler;

    @AndroidFindBy(id = "com.example.qatrainer:id/scroll_content")
    public WebElement scrollContent;

    @AndroidFindBy(id = "com.example.qatrainer:id/photo_view")
    public WebElement photoView;

    @AndroidFindBy(id = "com.example.qatrainer:id/layout_zoom_area")
    public WebElement zoomArea;

    @AndroidFindBy(accessibility = "Swipeable pages")
    public WebElement viewPagerAccessibility;

    @AndroidFindBy(accessibility = "Zoomable area, long press for menu, double tap to change color")
    public WebElement zoomAreaAccessibility;

    public GesturesPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
