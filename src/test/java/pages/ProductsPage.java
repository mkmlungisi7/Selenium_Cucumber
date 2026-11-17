package pages;

import Helpers.PageControls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends PageControls {

    public ProductsPage() {
    }
    public List<Double> getItemPrices() {
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> prices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }

        return prices;
    }

    public boolean isPriceOrdered(List<Double> prices) {
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public void filterItemsByPricing() {
        selectDropdownOption(By.cssSelector(".product_sort_container"),"lohi");
    }

    public void clickOnButton() {
        click(By.cssSelector("#back-to-products"));
    }
    public void assertElementContains(String locator, String text) {
        By byLocator;
        if (locator.startsWith("//")) {
            byLocator = By.xpath(locator);
        } else if (locator.startsWith("#")) {
            byLocator = By.cssSelector(locator);
        } else if (locator.startsWith(".")) {
            byLocator = By.cssSelector(locator);
        } else {
            byLocator = By.className(locator);
        }

        assertTextContains(byLocator, text);
    }
}
