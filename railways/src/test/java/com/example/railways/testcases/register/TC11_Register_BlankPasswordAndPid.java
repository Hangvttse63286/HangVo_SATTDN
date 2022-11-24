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

    @Test(description = "TC11-User can't create account while password and PID fields are empty")
    public void TC_Register_BlankPasswordAndPid() {
        ExtentTestManager.logMessage("TC11-User can't create account while password and PID fields are empty");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        ExtentTestManager.logMessage("Click on 'Register' tab");
        homePage.clickTab(Tab.REGISTER);

        String email = Utilities.generateRandomEmail(Utilities.getRandomNumber(6, 32));
        String password = "";
        String pid = "";
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password + " - Confirm Password: " + password + " - Pid: " + pid);

        RegisterPage registerPage = new RegisterPage();
        ExtentTestManager.logMessage("Enter valid email address and leave other fields empty");
        ExtentTestManager.logMessage("Click on 'Register' button");
        registerPage.register(email, password, password, pid);

        ExtentTestManager.logMessage("Expected: Message 'There're errors in the form. Please correct the errors and try again.' appears above the form.");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registerPage.isLblErrorDisplayed(), AssertMessage.ELEMENT_NOT_DISPLAYED.getMsg() + "label error msg");
        if (registerPage.isLblErrorDisplayed())
            softAssert.assertEquals(registerPage.getLblErrorText(), Message.REGISTER_FAILED.getMsg(), AssertMessage.VALUE_MISMATCH_WITH_EXPECTED.getMsg() + "label error msg");

        ExtentTestManager.logMessage("Expected: Next to password fields, error message 'Invalid password length.' displays");
        softAssert.assertTrue(registerPage.isLblPasswordErrorDisplayed(), AssertMessage.ELEMENT_NOT_DISPLAYED.getMsg() + "label password error msg");
        if (registerPage.isLblPasswordErrorDisplayed())
            softAssert.assertEquals(registerPage.getLblPasswordErrorText(), Message.REGISTER_PASSWORD_EMPTY.getMsg(), AssertMessage.VALUE_MISMATCH_WITH_EXPECTED.getMsg() + "label password error msg");

        ExtentTestManager.logMessage("Expected: Next to PID field, error message 'Invalid ID length.' displays");
        softAssert.assertTrue(registerPage.isLblPidErrorDisplayed(), AssertMessage.ELEMENT_NOT_DISPLAYED.getMsg() + "label pid error msg");
        if (registerPage.isLblPidErrorDisplayed())
            softAssert.assertEquals(registerPage.getLblPidErrorText(), Message.REGISTER_PID_EMPTY.getMsg(), AssertMessage.VALUE_MISMATCH_WITH_EXPECTED.getMsg() + "label pid error msg");

        softAssert.assertAll();
    }
}
