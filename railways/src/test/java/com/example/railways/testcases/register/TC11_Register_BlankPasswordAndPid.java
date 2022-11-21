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
public class TC11_Register_BlankPasswordAndPid extends BaseTest {

    @Override
    @BeforeMethod
    public void setUp() {
        DriverManager.pageLoadTimeout();
        DriverManager.implicitlyWait();
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
    }

    @Test
    public void TC_Register_BlankPasswordAndPid() {
        ExtentTestManager.logMessage("TC11-User can't create account while password and PID fields are empty");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Register\" tab");
        homePage.clickTab(Tab.REGISTER);

        String email = Utilities.generateRandomEmail(Utilities.getRandomNumber(6, 32));
        String password = "";
        String pid = "";
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password + " - Confirm Password: " + password + " - Pid: " + pid);

        RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Enter valid email address and leave other fields empty");
        ExtentTestManager.logMessage("Click on \"Register\" button");
        registerPage.register(email, password, password, pid);

        ExtentTestManager.logMessage("Expected: Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
        Assert.assertTrue(registerPage.isExistedLblError());
        Assert.assertEquals(registerPage.getLblErrorText(), Message.REGISTER_FAILED.getMsg());
        ExtentTestManager.logMessage("Expected: Next to password fields, error message \"Invalid password length.\" displays");
        ExtentTestManager.logMessage("Expected: Next to PID field, error message \"Invalid ID length.\" displays");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registerPage.isExistedLblPasswordValidationError());
        softAssert.assertTrue(registerPage.isExistedLblPidValidationError());
        softAssert.assertEquals(registerPage.getLblPasswordValidationErrorText(), Message.REGISTER_PASSWORD_EMPTY.getMsg());
        softAssert.assertEquals(registerPage.getLblPidValidationErrorText(), Message.REGISTER_PID_EMPTY.getMsg());
        softAssert.assertAll();
    }
}
