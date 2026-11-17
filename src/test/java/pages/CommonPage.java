package pages;

import Helpers.PageControls;
import org.openqa.selenium.By;


public class CommonPage extends PageControls {

    public CommonPage() {
    }
    public String pageTitle() {
        return getPageTitle();
    }
    public String pageUrl() {
        return getCurrentURL();
    }

    public void selectOption(String locator, String value) {
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
        selectDropdownOption(byLocator,value);
    }


}
