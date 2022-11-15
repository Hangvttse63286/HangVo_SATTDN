package com.example.railways.common.utilities;

import com.example.railways.common.constant.Browser;
import com.example.railways.dataObjects.ConfigFileReader;
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
        Browser browserType = Browser.valueOf(ConfigFileReader.getValue("browser"));
        switch (browserType) {
            case CHROME:
                driver = initChromeDriver();
                break;
            case FIREFOX:
                driver = initFirefoxDriver();
                break;
            default:
                System.out.println("Browser: " + browserType.getName() + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
                break;
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
