Feature: Login
  @RegressionTests
  Scenario: Login with valid username and password
    Given I am on the "qa" login page
    And Page should contain "Swag Labs"
    When the user enters valid username "standard_user" and password "saucePassword"
    And I click on the login button
    Then I should be logged in to the saucedemo website
    And Verify that page should contain "Swag Labs"

  @IntegrationTests
  Scenario: Login with locked username and password
    Given I am on the "qa" login page
    And Page should contain "Swag Labs"
    When the user enters valid username "locked_out_user" and password "saucePassword"
    And I click on the login button
    Then the user should not login successfully
