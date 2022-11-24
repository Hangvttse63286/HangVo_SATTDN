package com.example.railways.testcases.register;

import com.example.railways.common.constant.AssertMessage;
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

@Listeners(ReportListener.class)
public class TC10_Register_ConfirmPassword_Mismatch_Password extends BaseTest {

    @Override
    @BeforeMethod
    public void setUp() {
        DriverManager.pageLoadTimeout();
        DriverManager.implicitlyWait();
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
    }

    @Test(description = "TC10-User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC_Register_ConfirmPasswordMismatchPassword() {
        ExtentTestManager.logMessage("TC10-User can't create account with \"Confirm password\" is not the same with \"Password\"");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        ExtentTestManager.logMessage("Click on 'Register' tab");
        homePage.clickTab(Tab.REGISTER);

        String email = Utilities.generateRandomEmail(Utilities.getRandomNumber(6, 32));
        String password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        String confirmPassword = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        String pid = Utilities.generateRandomString(Utilities.getRandomNumber(8, 20));
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password + " - Confirm Password: " + confirmPassword + " - Pid: " + pid);

        RegisterPage registerPage = new RegisterPage();
        ExtentTestManager.logMessage("Enter valid information into all fields except 'Confirm password' is not the same with 'Password'");
        ExtentTestManager.logMessage("Click on 'Register' button");
        registerPage.register(email, password, confirmPassword, pid);

        ExtentTestManager.logMessage("Expected: Message \"There're errors in the form. Please correct the errors and try again.\" appears.");
        Assert.assertTrue(registerPage.isLblErrorDisplayed(), AssertMessage.ELEMENT_NOT_DISPLAYED.getMsg() + "label error msg");
        Assert.assertEquals(registerPage.getLblErrorText(), Message.REGISTER_FAILED.getMsg());
    }
}
