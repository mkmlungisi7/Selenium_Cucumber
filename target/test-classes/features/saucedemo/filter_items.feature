Feature: Filter Items

  @RegressionTests
  Scenario: Filter items by pricing
    Given I am on the "qa" login page
    And Page should contain "Swag Labs"
    When the user enters valid username "standard_user" and password "saucePassword"
    And I click on the login button
    Then I should be logged in to the saucedemo website
    And Verify that page should contain "Swag Labs"
    When the user filters items by pricing
    Then the user should see the first item as the lowest and the last item as the highest in price
