package com.example.railways.testcases.login;

import com.example.railways.dataObjects.Message;
import com.example.railways.dataObjects.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listenter.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class TC01_Login_ValidAcc extends BaseTest {

    @Test
    public void TC_Login_ValidAccount() {
        ExtentTestManager.logMessage("TC01-User can log into Railway with valid username and password");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());

        ExtentTestManager.logMessage("Click on \"Login\" tab");
        homePage.clickTab(Tab.LOGIN);

        String email = getEmail();
        String password = getPassword();
        Log.info("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.scrollToBtnLogin();
        ExtentTestManager.logMessage("Enter valid Email and Password");
        ExtentTestManager.logMessage("Click on \"Login\" button");
        loginPage.login(email, password);
        String welcomeText = loginPage.getWelcomeText().trim();

        ExtentTestManager.logMessage("Expected: User is logged into Railway. Welcome user message is displayed.");
        Assert.assertEquals(welcomeText, Message.LOGGED_WELCOME_TEXT.getMsg() + email);
    }
}
