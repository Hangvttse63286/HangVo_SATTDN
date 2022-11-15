package com.example.railways.testcases.register;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.constant.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.Utilities;
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
public class TC11_Register_BlankPasswordAndPid extends BaseTest {

    @Override
    @BeforeMethod
    public void setUp() {
        DriverManager.pageLoadTimeout(TimeUnit.SECONDS);
        DriverManager.implicitlyWait(TimeUnit.SECONDS);
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
    }

    @Test
    public void TC_Register_BlankPasswordAndPid() {
        Log.info("TC11-User can't create account while password and PID fields are empty");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Click on \"Register\" tab");
        homePage.getTab(Tab.REGISTER).click();

        String email = Utilities.generateRandomEmail(Utilities.getRandomNumber(6, 32));
        String password = "";
        String pid = "";
        Log.info("Email: " + email + " - Password: " + password + " - Confirm Password: " + password + " - Pid: " + pid);

        RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
        DriverManager.scrollToView(registerPage.getBtnRegister());
        Log.info("Enter valid email address and leave other fields empty");
        Log.info("Click on \"Register\" button");
        registerPage.register(email, password, password, pid);

        Log.info("Expected: Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
        Assert.assertTrue(registerPage.getMsgError().isDisplayed());
        Assert.assertEquals(registerPage.getMsgError().getText(), "There're errors in the form. Please correct the errors and try again.");
        Log.info("Expected: Next to password fields, error message \"Invalid password length.\" displays");
        Log.info("Expected: Next to PID field, error message \"Invalid ID length.\" displays");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registerPage.getMsgPasswordValidationError().isDisplayed());
        softAssert.assertTrue(registerPage.getMsgPidValidationError().isDisplayed());
        softAssert.assertEquals(registerPage.getMsgPasswordValidationError().getText(), "Invalid password length");
        softAssert.assertEquals(registerPage.getMsgPidValidationError().getText(), "Invalid ID length");
        softAssert.assertAll();
    }
}
