package com.example.railways.testcases.login;

import com.example.railways.dataObjects.Message;
import com.example.railways.dataObjects.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class TC02_Login_BlankUsername extends BaseTest {

    @Test(description = "TC02-User can't login with blank \"Username\" textbox")
    public void TC_Login_BlankUsername() {
        ExtentTestManager.logMessage("TC02-User can't login with blank \"Username\" textbox");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Login\" tab");
        homePage.clickTab(Tab.LOGIN);

        String email = "";
        String password = getPassword();
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        ExtentTestManager.logMessage("User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox ");
        ExtentTestManager.logMessage("Click on \"Login\" button");
        loginPage.login(email, password);

        ExtentTestManager.logMessage("Expected: User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
        Assert.assertTrue(loginPage.isDisplayedLblError());
        Assert.assertEquals(loginPage.getLblErrorText(), Message.LOGIN_BLANK_FIELD.getMsg());
    }
}
