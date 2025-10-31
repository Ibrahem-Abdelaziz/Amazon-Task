package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class AddToCartTest extends TestBase {

    HomePage homeObject;
    SearchResultsPage searchResultsObject;
    ProductPage productObject;
    CartPage cartObject;

    @BeforeMethod
    public void setUp() {
        homeObject = new HomePage(driver);
        searchResultsObject = new SearchResultsPage(driver);
        productObject = new ProductPage(driver);
        cartObject = new CartPage(driver);
    }

    @Story("Cart Status Validation")
    @Description("Ensure that when navigating to the cart with no items, the correct empty cart message is shown.")
    @Test(description = "Validate message shown for empty shopping cart")
    public void verifyEmptyCartMessage() {
        homeObject.goToCart();
        Assert.assertTrue(cartObject.getEmptyCartMessage().contains("Your Amazon Cart is empty"), "Cart is not empty as expected.");
    }

    @Story("Product Search Functionality")
    @Description("Confirm that the user can search for a product and view valid results.")
    @Test(description = "Check that product search returns relevant results")
    public void userCanSearchForProduct() {
        homeObject.searchForProduct("car accessories");
        Assert.assertTrue(searchResultsObject.getSearchedKeywordTxt().contains("car accessories"));
        searchResultsObject.clickFirstItem();
        Assert.assertTrue(productObject.isProductTitlePresent());
    }

    @Story("Single Item Cart Addition")
    @Description("Verify that a user is able to add a single product to their shopping cart.")
    @Test(description = "Confirm item can be added successfully to the cart")
    public void userCanAddItemToCart() {
        userCanSearchForProduct();
        productObject.addItemToCart();
        Assert.assertTrue(productObject.getProductAddedAlertAssertion().contains("Added to Cart"));
        homeObject.goToCart();
        Assert.assertTrue(cartObject.isCheckoutElementPresent());
        Assert.assertTrue(cartObject.isSubtotalElementPresent());
    }

    @Story("Cart Quantity Management")
    @Description("Ensure the user can select and add multiple quantities of a single product.")
    @Test(description = "Validate adding multiple quantities of the same product")
    public void userCanAddMultipleQuantities() {
        userCanSearchForProduct();
        productObject.selectQuantity(4);
        productObject.addItemToCart();
        homeObject.goToCart();
        Assert.assertTrue(cartObject.getCartQuantity().contains("4"));
    }

    @Story("Product Removal Flow")
    @Description("Confirm that users can remove items from their shopping cart successfully.")
    @Test(description = "Ensure product can be deleted from the cart")
    public void userCanRemoveProductFromCart() {
        userCanSearchForProduct();
        productObject.addItemToCart();
        homeObject.goToCart();
        cartObject.removeProductFromCart();
        homeObject.goToCart();
        Assert.assertTrue(cartObject.getEmptyCartMessage().contains("Your Amazon Cart is empty"), "Cart is not empty as expected.");
    }

    @Story("Multiple Item Handling")
    @Description("Check that the user can add more than one different product to the cart.")
    @Test(description = "Verify cart supports multiple distinct items")
    public void userCanAddMultipleItems() {
        userCanSearchForProduct();
        productObject.addItemToCart();
        homeObject.searchForProduct("car accessories");
        searchResultsObject.clickSecondItem();
        productObject.addItemToCart();
        homeObject.goToCart();
        Assert.assertEquals(homeObject.getCartCount(), "2");
    }

    @Story("Empty Search Validation")
    @Description("Test system behavior when user performs a search without entering any keyword.")
    @Test(description = "Ensure no action is taken for blank search input")
    public void verifyEmptyResultsForMissingSearchTerm() {
        String initialUrl = driver.getCurrentUrl();
        homeObject.searchForProduct("");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, initialUrl, "URL changed after performing empty search.");
    }

    @Story("Product Information Visibility")
    @Description("Verify that product details such as title and price are visible on the product page.")
    @Test(description = "Confirm that product information is displayed correctly")
    public void verifyProductDetailsAreDisplayed() {
        userCanSearchForProduct();
        Assert.assertTrue(productObject.isProductPricePresent());
        Assert.assertTrue(productObject.isProductTitlePresent());
    }
}
