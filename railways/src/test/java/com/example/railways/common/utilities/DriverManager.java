package com.example.railways.common.utilities;

import com.example.railways.dataObjects.ConfigFileReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver;
    private static final ConfigFileReader configFileReader = new ConfigFileReader();

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(String browserType) {
        switch (browserType) {
            case "CHROME":
                driver = initChromeDriver();
                break;
            case "FIREFOX":
                driver = initFirefoxDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
                break;
        }
    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + configFileReader.getDriverPath() + "chromedriver.exe");
        return new ChromeDriver();
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + configFileReader.getDriverPath() + "geckodriver.exe");
        return new FirefoxDriver();
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void pageLoadTimeout(TimeUnit timeUnit) {
        driver.manage().timeouts().pageLoadTimeout(configFileReader.getPageLoadTimeout(), timeUnit);
    }

    public static void implicitlyWait(TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), timeUnit);
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void clearAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public static void quit() {
        driver.quit();
    }
}
