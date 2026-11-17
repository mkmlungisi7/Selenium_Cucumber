Feature: Login to saucedemo.com
  As a user
  I want to log in to saucedemo.com
  So that I can access my account

  @RegressionTests
  Scenario: Successful login
    Given I am on the "qa" login page
    And Page should contain "Swag Labs"
    When the user enters valid username "standard_user" and password "saucePassword"
    And I click on the login button
    Then I should be logged in to the saucedemo website
    And Verify that page should contain "Swag Labs"
    And I click on a text "Sauce Labs Backpack"
    And I click on Add to cart for Sauce Labs Backpack
    Then item should be added to basket
    And I click on Remove for Sauce Labs Backpack
    And I click on Back to products
    And I click on a text "Sauce Labs Bike Light"
    And I click on Add to cart for Sauce Labs Bike Light
    Then item should be added to basket
    And I click on Remove for Sauce Labs Bike Light
    And I click on Back to products
    And I click on a text "Sauce Labs Bolt T-Shirt"
    And I click on Add to cart for Sauce Labs Bolt T-Shirt
    Then item should be added to basket
    And I click on Remove for Sauce Labs Bolt T-Shirt
    And I click on Back to products
    And I click on a text "Sauce Labs Fleece Jacket"
    And I click on Add to cart for Sauce Labs Fleece Jacket
    Then item should be added to basket
    And I click on Remove for Sauce Labs Fleece Jacket
    And I click on Back to products
    And I click on a text "Sauce Labs Onesie"
    And I click on Add to cart for Sauce Labs Onesie
    Then item should be added to basket
    And I click on Remove for Sauce Labs Onesie
    And I click on Back to products
    And I click on a text "Test.allTheThings() T-Shirt (Red)"
    And I click on Add to cart for T-Shirt (Red)
    Then item should be added to basket
    And I click on Remove for Sauce Labs T-Shirt (Red)
    And I click on Back to products
