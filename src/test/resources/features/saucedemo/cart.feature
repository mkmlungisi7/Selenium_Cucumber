Feature: Cart

  @IntegrationTests
  Scenario: Add items to the cart
    Given I am on the "qa" login page
    And Page should contain "Swag Labs"
    When the user enters valid username "standard_user" and password "saucePassword"
    And I click on the login button
    Then I should be logged in to the saucedemo website
    And Verify that page should contain "Swag Labs"
    And I click on Add to cart for Sauce Labs Backpack on products page
    And I click on Add to cart for Sauce Labs Bike Light on products page
    And I click on Add to cart for Sauce Labs Bolt T-Shirt on products page
    And I click on Add to cart for Sauce Labs Fleece Jacket on products page
    Then item should be added to basket
    Then the user should see "4" items in the cart
