package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

@Getter
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
        basePage.getTab("Login").click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://www.railwayb2.somee.com/Account/Login.cshtml");
    }

    @Test
    public void TC_002_Login_ValidAccount() {
        String username = "hang222@gmail.com";
        String password = "123123123";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getTab("Login").click();
        loginPage.login(username, password);
        String welcomeText = loginPage.getWelcomeText().getText().trim();
        loginPage.getTab("Log out").click();
        Assert.assertEquals(welcomeText, "Welcome " + username);
    }

    @Test
    public void TC_003_Register_ExistedEmail() {
        String email = "hang222@gmail.com";
        String password = "qwe123!@";
        String confirmPassword = "qwe123!@";
        String pid = "123123123";

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.getTab("Register").click();
        registerPage.register(email, password, confirmPassword, pid);
        Assert.assertTrue(registerPage.getErrorMsg().isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}