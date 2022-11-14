package com.example.railways.testcases.login;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_Login_InvalidPassword extends BaseTest {

    @Test
    public void TC_Login_InvalidPassword() {
        Log.info("TC03-User cannot log into Railway with invalid password");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Click on \"Login\" tab");
        homePage.getTab(Tab.LOGIN).click();

        String email = getEmail();
        String password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        Log.info("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        Log.info("Enter valid Email and invalid Password");
        Log.info("Click on \"Login\" button");
        loginPage.login(email, password);

        Log.info("Expected: Error message \"There was a problem with your login and/or errors exist in your form.\" is displayed");
        Assert.assertTrue(loginPage.getMsgError().isDisplayed());
        Assert.assertEquals(loginPage.getMsgError().getText(), "Invalid username or password. Please try again.");
    }
}
