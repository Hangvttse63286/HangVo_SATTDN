package com.example.railways.testcases.login;

import com.example.railways.dataObjects.Message;
import com.example.railways.dataObjects.Tab;
import com.example.railways.dataObjects.Url;
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
public class TC08_Login_InactivatedAccount extends BaseTest {

    @Test
    public void TC_Login_InactivatedAccount() {
        ExtentTestManager.logMessage("TC08-User can't login with an account hasn't been activated");
        ExtentTestManager.logMessage("Pre-condition: Create a new account but do not activate it");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Login\" tab");
        homePage.clickTab(Tab.LOGIN);

        String email = getEmail();
        String password = getPassword();
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.scrollToBtnLogin();
        ExtentTestManager.logMessage("Enter username and password of account hasn't been activated.");
        ExtentTestManager.logMessage("Click on \"Login\" button");
        loginPage.login(email, password);

        ExtentTestManager.logMessage("Expected: User can't login and message \"Invalid username or password. Please try again.\" appears.");
        String welcomeText = loginPage.getWelcomeText().trim();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), Url.RAILWAYS_LOGIN_URL.getUrlLink());
        softAssert.assertEquals(welcomeText, Message.UNLOGGED_WELCOME_TEXT.getMsg());
        softAssert.assertEquals(loginPage.getLblErrorText(), Message.LOGIN_INVALID_ACCOUNT.getMsg());
        softAssert.assertAll();
    }
}
