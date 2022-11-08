package com.example.railways.testcases;

import com.example.railways.common.constant.Constant;
import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.BaseSetup;
import com.example.railways.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseSetup {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test(priority = 2)
    public void TC_001_ValidateLoginNavigation() {
        loginPage = new LoginPage(driver);
        loginPage.getTab(Tab.LOGIN.getName()).click();
        Assert.assertEquals(driver.getCurrentUrl(), Constant.RAILWAYS_LOGIN_URL);
    }

    @Test(priority = 1)
    public void TC_002_Login_ValidAccount() {
        String email = Constant.EMAIL;
        String password = Constant.PASSWORD;

        loginPage = new LoginPage(driver);
        loginPage.getTab(Tab.LOGIN.getName()).click();
        loginPage.login(email, password);
        String welcomeText = loginPage.getLoc_lblWelcomeText().getText().trim();
        Assert.assertEquals(welcomeText, "Welcome " + email);
//        loginPage.getTab(Tab.LOGOUT.getName()).click();
    }
}