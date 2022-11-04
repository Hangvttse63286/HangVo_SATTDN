package com.example.railways;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class BasePageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Webdriver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.railwayb2.somee.com/");
    }

    @Test
    public void TC_001_ValidateLoginNavigation() {
        BasePage basePage = new BasePage(driver);
        basePage.navigate("Login");
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.railwayb2.somee.com/Account/Login.cshtml");
    }

    @Test
    public void TC_002_LoginSuccess() {
        String username = "hang222@gmail.com";
        String password = "qwe123!@";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate("Login");
        loginPage.login(username, password);
        String welcomeText = loginPage.getWelcomeText().trim();
        loginPage.navigate("Log out");
        Assert.assertEquals(welcomeText, "Welcome " + username);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}