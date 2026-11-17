package stepdefs;

import Helpers.PageControls;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pages.CommonPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.io.IOException;
import static org.junit.Assert.assertEquals;


public class AdactinHotelAppStepsDefs {
    private final LoginPage loginPage = new LoginPage();
    private final CommonPage commonPage = new CommonPage();

    private final ProductsPage productsPage = new ProductsPage();

    public AdactinHotelAppStepsDefs() throws IOException {
    }


    @Given("I launch the hotel reservation application using the URL {string}")
    public void iLaunchTheHotelReservationApplicationUsingTheURL(String env) throws IOException
    {
            loginPage.navigateToLoginPage(env);
    }

    @When("I login to the application using username {string} and password {string}")
    public void iLoginToTheApplicationUsingUsernameAndPassword(String username, String password) {
        loginPage.enterInput("username",username);
        loginPage.enterInput("password",password);
        loginPage.clickLoginButton("login");
    }


    @Then("the user should be logged in to the application")
    public void theUserShouldBeLoggedInToTheApplication() {
        assertEquals("Adactin.com - Search Hotel", commonPage.pageTitle());
    }

    @And("the page URL should be {string}")
    public void thePageURLShouldBe(String url) throws InterruptedException {
        Thread.sleep(1000);
        assertEquals(url, commonPage.pageUrl());
    }

    @And("I select the location as {string}")
    public void iSelectTheLocationAs(String text) {
        commonPage.selectOption("location", text);
    }

    @And("I select the hotel as {string}")
    public void iSelectTheHotelAs(String text) {
        commonPage.selectOption("#hotels", text);
    }

    @And("I select the room type as {string}")
    public void iSelectTheRoomTypeAs(String text) {
        commonPage.selectOption("#room_type", text);
    }

    @And("I enter the number of rooms as {string}")
    public void iEnterTheNumberOfRoomsAs(String text) {
        commonPage.selectOption("#room_nos",text);
    }

    @When("I enter the check-in date as today {int} days")
    public void enterCheckInDate(int daysToAdd) {
        String date = commonPage.getTodayPlusDate(daysToAdd);
        loginPage.enterInput("#datepick_in",date);
    }

    @And("I enter the check-out date as today {int} days")
    public void iEnterTheCheckOutDateAsTodayDays(int daysToAdd) {
        String date = commonPage.getTodayPlusDate(daysToAdd);
        loginPage.enterInput("#datepick_out",date);
    }

    @Then("I should be able to make the reservation")
    public void iShouldBeAbleToMakeTheReservation() {
        loginPage.clickButton("input#Submit");
        productsPage.assertElementContains("#checkin_span","Check-In Date shall be before than Check-Out Date");
        productsPage.assertElementContains("#checkout_span","Check-Out Date shall be after than Check-In Date");
    }
    @After
    public void tearDown() {
        PageControls.closeDriver();
    }
}


