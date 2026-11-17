# SeleniumJavaWithCucumberBDD

This repository contains a package of Selenium automation code helpers that can be used in your automation projects. It includes:

PageControls.java: a class that contains methods to interact with web elements such as click, sendKeys, getText, isDisplayed, assertTextContains and closeDriver.

LoginPage.java: a class that extends PageControls class and provides methods for interacting with elements on the login page of a website.

LoginStepDefinitions.java: a class that uses LoginPage methods to define Cucumber step definitions for a login feature.

# Requirements

Java JDK 11 or later
Selenium WebDriver
io.cucumber, junit, and io.github.bonigarcia dependencies
ChromeDriver for Google Chrome browser
# Installation
To use this package, you need to add it to your project as a dependency. You can do this by following these steps:

Clone this repository to your local machine.
Import the PageControls, LoginPage, and LoginStepDefinitions classes into your project.
Make sure you have the required dependencies installed in your project's pom.xml file.
Make sure you have ChromeDriver installed on your machine.
# Usage

To use the PageControls, LoginPage, and LoginStepDefinitions classes in your project, follow these steps:

Create an instance of the LoginPage class.
Use the navigateToLoginPage method to navigate to the login page of the website.
Use the setUsername and setPassword methods to enter valid credentials.
Use the clickLoginButton method to click on the login button.
Use the assertElementIsDisplayed method to verify that the user is logged in.
Contributions
Contributions are welcome! If you find a bug or have an idea for a new feature, please create a new issue or a pull request.

# License

This package is licensed under the MIT License.
