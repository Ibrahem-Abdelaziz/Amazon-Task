package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class TodayDealsTest extends TestBase {
    HomePage homeObject;
    TodayDealsPage todayDealsObject;
    ProductPage productObject;
    CartPage cartObject;

    @BeforeMethod
    public void setUp() {
        homeObject = new HomePage(driver);
        todayDealsObject = new TodayDealsPage(driver);
        productObject = new ProductPage(driver);
        cartObject = new CartPage(driver);
    }

    @Story("Access Daily Deals Section")
    @Description("Ensure the user is able to open and view the Today’s Deals section from the homepage.")
    @Test(description = "Validate navigation to the Today’s Deals page")
    public void userCanNavigateToTodayDealsSuccessfully() {
        homeObject.navigateToTodayDealsPage();
    }

    @Story("Filter and Purchase from Deals")
    @Description("Check that the user can apply available filters in Today’s Deals and successfully add a filtered product to the shopping cart.")
    @Test(description = "Verify filtering and adding a deal item to the cart")
    public void userCanApplyFiltersAndAddItemToCart() throws InterruptedException {
        homeObject.navigateToTodayDealsPage();

        todayDealsObject.applyFilters();
        productObject.addItemToCart();

        Assert.assertTrue(productObject.getProductAddedAlertAssertion().contains("Added to Cart"));
    }
}
