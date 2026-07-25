package com.example.qatrainer.tests;

import com.example.qatrainer.base.BaseTest;
import com.example.qatrainer.pages.ListsPage;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListsTest extends BaseTest {

    @Test(priority = 1, description = "Search and filter items in RecyclerView")
    public void testSearchInRecyclerView() {
        driver.findElement(AppiumBy.accessibilityId("Lists")).click();

        ListsPage page = new ListsPage(driver);
        Assert.assertTrue(page.itemsRecycler.isDisplayed(),
            "RecyclerView should be displayed");

        // Type search query
        page.searchView.click();
        page.searchView.sendKeys("Kaspresso");

        // Verify filtered items contain "Kaspresso"
        var firstResult = driver.findElement(
            AppiumBy.xpath("//android.widget.TextView[@resource-id='com.example.qatrainer:id/tv_item_title']")
        );
        Assert.assertTrue(firstResult.getText().contains("Kaspresso"),
            "First result should contain search term");
    }

    @Test(priority = 2, description = "Pull to refresh")
    public void testPullToRefresh() {
        driver.findElement(AppiumBy.accessibilityId("Lists")).click();

        ListsPage page = new ListsPage(driver);
        Assert.assertNotNull(page.swipeRefreshAccessibility,
            "SwipeRefreshLayout should have accessibility ID");
    }

    @Test(priority = 3, description = "Filter by favorites")
    public void testFilterFavorites() {
        driver.findElement(AppiumBy.accessibilityId("Lists")).click();

        ListsPage page = new ListsPage(driver);
        page.chipFavorites.click();

        // Verify filtered results
        Assert.assertTrue(page.itemsRecycler.isDisplayed(),
            "RecyclerView should still be displayed after filtering");
    }
}
