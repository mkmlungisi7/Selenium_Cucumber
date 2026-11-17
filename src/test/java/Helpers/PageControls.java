package Helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Properties;

public class PageControls {
    public static WebDriver driver;

    public PageControls(String browserType) {
        if (driver == null) {

            if (browserType.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
//                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            } else if (browserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless"); // Enable headless mode
                driver = new FirefoxDriver(options);
            } else if (browserType.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless"); // Enable headless mode
                driver = new EdgeDriver(options);
            } else {
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
    }

    public PageControls() {
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static String getProperty(String key) {
        ConfigReader configReader = new ConfigReader();
        Properties properties = configReader.initProp();    // Reading from config properties file
        return properties.getProperty(key);
    }

    //base64 encoding: This is used to encrypt the password and save the encrypted value in config.properties file
    public static void encrypt() {
        try {
            byte[] encodedBytes = Base64.getEncoder().encode("yourPassword".getBytes(StandardCharsets.UTF_8));
            String encodedValue = new String(encodedBytes);
        } catch (Exception e) {
            System.out.println("Password was not Encrypted.");
        }
    }

    //base64 decoding: This is used to decrypt the password from the encrypted value in config.properties file while passing to app
    public static String decrypt(String passwordField) {
        String encodedBytes = PageControls.getProperty(passwordField);
        String decodedString = "";
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
            decodedString = new String(decodedBytes);
        } catch (Exception e) {
            System.out.println("Password was nor Decrypted.");
        }
        return decodedString;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        findElement(locator).click();
    }
    public void isVisible(By locator) {
        findElement(locator).isDisplayed();
    }
    public void sendKeys(By locator, String text) {
        findElement(locator).clear();
        findElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    public void assertTextContains(By locator, String expectedText) {
        WebElement element = findElement(locator);
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    public void selectDropdownOption(By locator, String optionText) {
        WebElement dropdownElement = findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(optionText);
    }
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
    public void captureScreenshot(String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(fileName);
        try {
            Files.copy(screenshotFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot captured: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
    public String getTodayMinusDate(int days) {
        LocalDate today = LocalDate.now();
        LocalDate checkInDate = today.minusDays(days);
        return formatDate(checkInDate);
    }

    public String getTodayPlusDate(int days) {
        LocalDate today = LocalDate.now();
        LocalDate checkInDate = today.plusDays(days);
        return formatDate(checkInDate);
    }
    private static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
}
