package com.example.railways.testcases.register;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.constant.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listenter.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.RegisterPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

@Listeners(ReportListener.class)
public class TC07_Register_Success extends BaseTest {

    @Override
    @BeforeMethod
    public void setUp() {
        DriverManager.pageLoadTimeout(TimeUnit.SECONDS);
        DriverManager.implicitlyWait(TimeUnit.SECONDS);
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
    }

    @Test
    public void TC_Register_ValidFields() {
        ExtentTestManager.logMessage("TC07-User can create new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Register\" tab");
        homePage.getTab(Tab.REGISTER).click();

        String email = Utilities.generateRandomEmail(Utilities.getRandomNumber(6, 32));
        String password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        String pid = Utilities.generateRandomString(Utilities.getRandomNumber(8, 20));
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password + " - Confirm Password: " + password + " - Pid: " + pid);

        RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
        DriverManager.scrollToView(registerPage.getBtnRegister());
        ExtentTestManager.logMessage("Enter valid information into all fields");
        ExtentTestManager.logMessage("Click on \"Register\" button");
        registerPage.register(email, password, password, pid);

        ExtentTestManager.logMessage("Expected: New account is created and message \"You're here\"");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registerPage.getMsgSuccess().isDisplayed());
        softAssert.assertEquals(registerPage.getMsgSuccess().getText(), "You're here");
        softAssert.assertAll();
    }
}
