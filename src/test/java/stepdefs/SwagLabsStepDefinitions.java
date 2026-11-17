package stepdefs;


import Helpers.PageControls;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SwagLabsStepDefinitions {
    private final LoginPage loginPage = new LoginPage();
    private final ProductsPage productsPage = new ProductsPage();
    private List<Double> itemPrices;
    public SwagLabsStepDefinitions() throws IOException {
    }

@Given("I am on the {string} login page")
public void i_am_on_the_login_page(String env) throws IOException {
    loginPage.navigateToLoginPage(env);
}

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.clickLoginButton("#login-button");
    }
    @Then("I should be logged in to the saucedemo website")
    public void iShouldBeLoggedInToTheSaucedemoWebsite() {
        // Verify that the user is logged in by checking for an element on the next page
        loginPage.assertElementIsDisplayed("#inventory_container");
    }
    @Then("Verify that page should contain {string}")
    public void theH2ElementShouldContain(String expectedText) {
        assertEquals(expectedText, productsPage.getPageTitle());
    }

    @And("Page should contain {string}")
    public void pageShouldContain(String expectedText) {
        productsPage.assertElementContains(".login_logo", expectedText);
    }

    @And("I click on a text {string}")
    public void iClickOnAText(String text) {
        loginPage.clickText(text);
    }

    @Then("item should be added to basket")
    public void itemShouldBeAddedToBasket() {
        loginPage.assertElementIsDisplayed(".shopping_cart_badge");
    }


    @And("I click on Remove for Sauce Labs Backpack")
    public void iClickOnRemoveButtonSauceLabsBackpack() {
        loginPage.clickButton("#remove");
    }
    @And("I click on Add to cart for Sauce Labs Backpack")
    public void iClickOnAButtonForSauceLabsBackpack() {
        loginPage.clickButton("#add-to-cart");
    }

    @And("I click on Add to cart for Sauce Labs Backpack on products page")
    public void iClickOnAButtonForSauceLabsBackpackOnProductsPage() {
        loginPage.clickButton("#add-to-cart-sauce-labs-backpack");
    }
    @And("I click on Remove for Sauce Labs Bike Light")
    public void iClickOnRemoveButtonSauceLabsBikeLight() {
        loginPage.clickButton("#remove");
    }
    @And("I click on Add to cart for Sauce Labs Bike Light")
    public void iClickOnAButtonForSauceLabsBikeLight() {
        loginPage.clickButton("#add-to-cart");
    }

    @And("I click on Add to cart for Sauce Labs Bike Light on products page")
    public void iClickOnAButtonForSauceLabsBikeLightOnProductsPage() {
        loginPage.clickButton("#add-to-cart-sauce-labs-bike-light");
    }
    @And("I click on Add to cart for Sauce Labs Bolt T-Shirt on products page")
    public void iClickOnAButtonForSauceLabsBoltTShirtOnProductsPage() {
        loginPage.clickButton("#add-to-cart-sauce-labs-bolt-t-shirt");
    }

    @And("I click on Add to cart for Sauce Labs Fleece Jacket on products page")
    public void iClickOnAButtonForSauceLabsFleeceOnProductsPage() {
        loginPage.clickButton("#add-to-cart-sauce-labs-fleece-jacket");
    }
    @And("I click on Remove for Sauce Labs Bolt T-Shirt")
    public void iClickOnRemoveButtonSauceLabsBoltTShirt() {
        loginPage.clickButton("#remove");
    }
    @And("I click on Add to cart for Sauce Labs Bolt T-Shirt")
    public void iClickOnAButtonForSauceLabsBoltTShirt() {
        loginPage.clickButton("#add-to-cart");
    }
    @And("I click on Remove for Sauce Labs Fleece Jacket")
    public void iClickOnRemoveButtonSauceLabsFleece() {
        loginPage.clickButton("#remove");
    }
    @And("I click on Add to cart for Sauce Labs Fleece Jacket")
    public void iClickOnAButtonForSauceLabsFleece() {
        loginPage.clickButton("#add-to-cart");
    }
    @And("I click on Remove for Sauce Labs Onesie")
    public void iClickOnRemoveButtonSauceLabsOnesie() {
        loginPage.clickButton("#remove");
    }
    @And("I click on Add to cart for Sauce Labs Onesie")
    public void iClickOnAButtonForSauceLabsOnesie() {
        loginPage.clickButton("#add-to-cart");
    }

    @And("I click on Add to cart for T-Shirt \\(Red)")
    public void iClickOnAddToCartForTestAllTheThingsTShirtRed() {
        loginPage.clickButton("#add-to-cart");
    }


    @And("I click on Remove for Sauce Labs T-Shirt \\(Red)")
    public void iClickOnRemoveForSauceLabsTestAllTheThingsTShirtRed() {
        loginPage.clickButton("#remove");
    }

    @And("I click on Back to products")
    public void iClickOn() {
        productsPage.clickOnButton();
    }

    @When("the user enters valid username {string} and password {string}")
    public void theUserEntersValidUsernameAndPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }


    @Then("the user should not login successfully")
    public void theUserShouldNotLoginSuccessfully() {
        productsPage.assertElementContains(".error-message-container.error","Epic sadface: Sorry, this user has been locked out.");
    }
    @Then("the user should see {string} items in the cart")
    public void theUserShouldSeeItemsInTheCart(String text) {
        productsPage.assertElementContains(".shopping_cart_badge", text);
    }

    @When("the user filters items by pricing")
    public void theUserFiltersItemsByPricing() {
        productsPage.filterItemsByPricing();
    }

    @Then("^the user should see the first item as the lowest and the last item as the highest in price$")
    public void verifyFilteredItems() {
        // Get the prices of all items
        itemPrices = productsPage.getItemPrices();
        // Verify the ordering of item prices
        boolean isOrdered = productsPage.isPriceOrdered(itemPrices);
        System.out.println(itemPrices);
        assertEquals( isOrdered,true);
    }

    @After
    public void tearDown() {
        PageControls.closeDriver();
    }
}
