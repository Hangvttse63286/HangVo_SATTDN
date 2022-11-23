package com.example.railways.testcases.register;

import com.example.railways.dataObjects.Message;
import com.example.railways.dataObjects.Tab;
import com.example.railways.dataObjects.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.RegisterPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class TC07_Register_Success extends BaseTest {

    @Override
    @BeforeMethod
    public void setUp() {
        DriverManager.pageLoadTimeout();
        DriverManager.implicitlyWait();
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
    }

    @Test(description = "TC07-User can create new account")
    public void TC_Register_ValidFields() {
        ExtentTestManager.logMessage("TC07-User can create new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Register\" tab");
        homePage.clickTab(Tab.REGISTER);

        String email = Utilities.generateRandomEmail(Utilities.getRandomNumber(6, 32));
        String password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        String pid = Utilities.generateRandomString(Utilities.getRandomNumber(8, 20));
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password + " - Confirm Password: " + password + " - Pid: " + pid);

        RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Enter valid information into all fields");
        ExtentTestManager.logMessage("Click on \"Register\" button");
        registerPage.register(email, password, password, pid);

        ExtentTestManager.logMessage("Expected: New account is created and message \"You're here\"");
        Assert.assertTrue(registerPage.isDisplayedLblSuccess());
        Assert.assertEquals(registerPage.getLblSuccessText(), Message.REGISTER_SUCCESS.getMsg());
    }
}
