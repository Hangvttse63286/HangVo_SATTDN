package com.example.railways.testcases.changePassword;

import com.example.railways.dataObjects.Message;
import com.example.railways.dataObjects.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.ChangePasswordPage;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class TC09_ChangePassword_Success extends BaseTest {

    @Test(description = "TC09-User can change password")
    public void TC_ChangePassword_ValidFields() {
        ExtentTestManager.logMessage("TC09-User can change password");
        ExtentTestManager.logMessage("Pre-condition: Create and activate a new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Login with valid account");
        homePage.clickTab(Tab.LOGIN);
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(getEmail(), getPassword());
        ExtentTestManager.logMessage("Click on \"Change Password\" tab");
        loginPage.clickTab(Tab.CHANGE_PASSWORD);

        String newPassword = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        ExtentTestManager.logMessage("New Password: " + newPassword);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(DriverManager.getDriver());
        changePasswordPage.scrollToBtnChangePassword();
        ExtentTestManager.logMessage("Enter valid value into all fields.");
        ExtentTestManager.logMessage("Click on \"Change Password\" button");
        changePasswordPage.changePassword(getPassword(), newPassword, newPassword);

        ExtentTestManager.logMessage("Expected: Message \"Your password has been updated!\" appears.");
        Assert.assertTrue(changePasswordPage.isDisplayedLblSuccess());
        Assert.assertEquals(changePasswordPage.getLblSuccessText(), Message.CHANGE_PASSWORD_SUCCESS.getMsg());
    }
}
