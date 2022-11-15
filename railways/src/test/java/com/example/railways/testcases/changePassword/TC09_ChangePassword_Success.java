package com.example.railways.testcases.changePassword;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.listenter.ReportListener;
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

    @Test
    public void TC_ChangePassword_ValidFields() {
        Log.info("TC09-User can change password");
        Log.info("Pre-condition: Create and activate a new account");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Login with valid account");
        homePage.getTab(Tab.LOGIN).click();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        loginPage.login(getEmail(), getPassword());
        Log.info("Click on \"Change Password\" tab");
        loginPage.getTab(Tab.CHANGE_PASSWORD).click();

        String newPassword = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        Log.info("New Password: " + newPassword);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(DriverManager.getDriver());
        DriverManager.scrollToView(changePasswordPage.getBtnChangePassword());
        Log.info("Enter valid value into all fields.");
        Log.info("Click on \"Change Password\" button");
        changePasswordPage.changePassword(getPassword(), newPassword, newPassword);

        Log.info("Expected: Message \"Your password has been updated!\" appears.");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(changePasswordPage.getMsgSuccess().isDisplayed());
        softAssert.assertEquals(changePasswordPage.getMsgSuccess().getText(), "Your password has been updated!");
        softAssert.assertAll();
    }
}
