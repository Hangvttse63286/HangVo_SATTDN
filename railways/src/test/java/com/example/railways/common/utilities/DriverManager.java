package com.example.railways.common.utilities;

import com.example.railways.common.constant.Browser;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.helpers.ConfigFileReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver() {
        Browser browserType;
        String configBrowser = ConfigFileReader.getValue("browser");
        try {
            browserType = Browser.fromString(configBrowser);
            switch (browserType) {
                case CHROME:
                    driver = initChromeDriver();
                    break;
                case FIREFOX:
                    driver = initFirefoxDriver();
                    break;
                default:
                    System.out.println("Browser: " + browserType.name() + " is invalid, Launching Chrome as browser of choice...");
                    driver = initChromeDriver();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Browser: " + configBrowser + " is invalid, Launching Chrome as browser of choice...");
            driver = initChromeDriver();
        }
    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + ConfigFileReader.getValue("driverPath") + "chromedriver.exe");
        return new ChromeDriver();
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + ConfigFileReader.getValue("driverPath") + "geckodriver.exe");
        return new FirefoxDriver();
    }

    public static void open(String url) {
        driver.get(url);
    }

    public static void pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigFileReader.getValue("pageLoadTimeout"))));
    }

    public static void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigFileReader.getValue("implicitlyWait"))));
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

    private static Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    public static void acceptAlert() {
        switchToAlert().accept();
    }

    public static void dismissAlert() {
        switchToAlert().dismiss();
    }

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public static void quit() {
        driver.quit();
    }
}
