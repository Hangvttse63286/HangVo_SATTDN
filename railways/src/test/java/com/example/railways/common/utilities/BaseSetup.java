package com.example.railways.common.utilities;

import com.example.railways.common.constant.Constant;
import com.example.railways.common.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseSetup {

    private WebDriver driver;

    static String driverPath = "\\Executables\\";

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL);
        }
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + driverPath + "geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(appURL);
        return driver;
    }

    @BeforeClass
    public void initializeTestBaseSetup() {
        try {

            setDriver(Constant.CHROME, Constant.RAILWAYS_URL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
