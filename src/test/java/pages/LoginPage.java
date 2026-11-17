package pages;

import Helpers.PageControls;
import org.openqa.selenium.By;
import java.io.IOException;

public class LoginPage {

    PageControls pageControls = new PageControls("chrome");

    public LoginPage() throws IOException {
    }

    public void setPassword(String password) {
        pageControls.sendKeys(By.id("password"), PageControls.decrypt(password));
    }

    public void assertElementIsDisplayed(String text) {
        pageControls.isDisplayed(By.cssSelector(text));
    }

    public void clickLoginButton(String locator) {
        By byLocator;
        if (locator.startsWith("//")) {
            byLocator = By.xpath(locator);
        } else if (locator.startsWith("#")) {
            byLocator = By.cssSelector(locator);
        } else if (locator.startsWith(".")) {
            byLocator = By.cssSelector(locator);
        } else {
            byLocator = By.id(locator);

        }
        pageControls.click(byLocator);

    }
    public void enterInput(String locator, String value) {
        By byLocator;
        if (locator.startsWith("//")) {
            byLocator = By.xpath(locator);
        } else if (locator.startsWith("#")) {
            byLocator = By.cssSelector(locator);
        } else if (locator.startsWith(".")) {
            byLocator = By.cssSelector(locator);
        } else {
            byLocator = By.id(locator);
        }
        pageControls.sendKeys(byLocator,value);
    }

    public void setUsername(String username) {
        pageControls.sendKeys(By.id("user-name"), username);
    }

    public void navigateToLoginPage(String env) throws IOException {
        String url = PageControls.getProperty(env);
        PageControls.driver.get(url);
    }

    public void clickButton(String button) {
        pageControls.click(By.cssSelector(button));
    }

    public void clickText(String text) {
        pageControls.click(By.linkText(text));
    }


}
