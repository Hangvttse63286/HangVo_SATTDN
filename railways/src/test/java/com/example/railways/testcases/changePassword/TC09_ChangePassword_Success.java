package com.example.railways.testcases.changePassword;

import com.example.railways.common.constant.AssertMessage;
import com.example.railways.dataObjects.Message;
import com.example.railways.dataObjects.Tab;
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

@Listeners(ReportListener.class)
public class TC09_ChangePassword_Success extends BaseTest {

    @Test(description = "TC09-User can change password")
    public void TC_ChangePassword_ValidFields() {
        ExtentTestManager.logMessage("TC09-User can change password");
        ExtentTestManager.logMessage("Pre-condition: Create and activate a new account");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        ExtentTestManager.logMessage("Login with valid account");
        homePage.clickTab(Tab.LOGIN);
        LoginPage loginPage = new LoginPage();
        loginPage.login(getEmail(), getPassword());
        ExtentTestManager.logMessage("Click on \"Change Password\" tab");
        loginPage.clickTab(Tab.CHANGE_PASSWORD);

        String newPassword = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        ExtentTestManager.logMessage("New Password: " + newPassword);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.scrollToBtnChangePassword();
        ExtentTestManager.logMessage("Enter valid value into all fields.");
        ExtentTestManager.logMessage("Click on \"Change Password\" button");
        changePasswordPage.changePassword(getPassword(), newPassword, newPassword);

        ExtentTestManager.logMessage("Expected: Message \"Your password has been updated!\" appears.");
        Assert.assertTrue(changePasswordPage.isLblSuccessDisplayed(), AssertMessage.ELEMENT_NOT_DISPLAYED.getMsg() + "label success msg");
        Assert.assertEquals(changePasswordPage.getLblSuccessText(), Message.CHANGE_PASSWORD_SUCCESS.getMsg());
    }
}
