package com.example.railways.testcases.login;

import com.example.railways.dataObjects.Message;
import com.example.railways.dataObjects.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listenter.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class TC03_Login_InvalidPassword extends BaseTest {

    @Test
    public void TC_Login_InvalidPassword() {
        ExtentTestManager.logMessage("TC03-User cannot log into Railway with invalid password");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Login\" tab");
        homePage.clickTab(Tab.LOGIN);

        String email = getEmail();
        String password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.scrollToBtnLogin();
        ExtentTestManager.logMessage("Enter valid Email and invalid Password");
        ExtentTestManager.logMessage("Click on \"Login\" button");
        loginPage.login(email, password);

        ExtentTestManager.logMessage("Expected: Error message \"Invalid username or password. Please try again.\" is displayed");
        Assert.assertTrue(loginPage.isExistedMsgError());
        Assert.assertEquals(loginPage.getMsgErrorText(), Message.LOGIN_INVALID_ACCOUNT.getMsg());
    }
}
