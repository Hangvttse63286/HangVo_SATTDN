package com.example.railways.testcases.login;

import com.example.railways.common.utilities.Utilities;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class TC08_Login_UnregisteredAccount extends BaseTest {

    @Override
    @BeforeMethod
    public void setUp() {
        DriverManager.pageLoadTimeout();
        DriverManager.implicitlyWait();
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
    }

    @Test(description = "TC-08: User can't login with an account hasn't been registered")
    public void TC_Login_UnregisteredAccount() {
        ExtentTestManager.logMessage("TC-08: User can't login with an account hasn't been registered");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Login\" tab");
        homePage.clickTab(Tab.LOGIN);

        String email = Utilities.generateRandomEmail(Utilities.getRandomNumber(6, 32));
        String password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Enter account hasn't been registered.");
        ExtentTestManager.logMessage("Click on \"Login\" button");
        loginPage.login(email, password);

        ExtentTestManager.logMessage("Expected: User can't login and message \"Invalid username or password. Please try again.\" appears.");
        Assert.assertTrue(loginPage.isDisplayedLblError());
        Assert.assertEquals(loginPage.getLblErrorText(), Message.LOGIN_INVALID_ACCOUNT.getMsg());
    }
}
