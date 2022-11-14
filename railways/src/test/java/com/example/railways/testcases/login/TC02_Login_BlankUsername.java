package com.example.railways.testcases.login;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_Login_BlankUsername extends BaseTest {

    @Test
    public void TC_Login_BlankUsername() {
        Log.info("TC02-User can't login with blank \"Username\" textbox");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Click on \"Login\" tab");
        homePage.getTab(Tab.LOGIN).click();

        String email = "";
        String password = getPassword();
        Log.info("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        Log.info("User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox ");
        Log.info("Click on \"Login\" button");
        loginPage.login(email, password);

        Log.info("Expected: User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
        Assert.assertTrue(loginPage.getMsgError().isDisplayed());
        Assert.assertEquals(loginPage.getMsgError().getText(), "There was a problem with your login and/or errors exist in your form.");
    }
}
