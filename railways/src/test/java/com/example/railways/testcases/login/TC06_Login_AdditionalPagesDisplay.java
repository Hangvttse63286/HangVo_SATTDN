package com.example.railways.testcases.login;

import com.example.railways.common.constant.AssertMessage;
import com.example.railways.dataObjects.Tab;
import com.example.railways.dataObjects.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class TC06_Login_AdditionalPagesDisplay extends BaseTest {

    @Test(description = "TC06-Additional pages display once user logged in")
    public void TC_Login_ValidAccount_AdditionalPagesDisplay() {
        ExtentTestManager.logMessage("TC06-Additional pages display once user logged in");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Login\" tab");
        homePage.clickTab(Tab.LOGIN);

        String email = getEmail();
        String password = getPassword();
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Login with valid account");
        loginPage.login(email, password);

        ExtentTestManager.logMessage("Expected: \"My ticket\", \"Change password\" and \"Logout\" tabs are displayed. ");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isDisplayed(Tab.MY_TICKET), AssertMessage.ELEMENT_NOT_DISPLAYED.getMsg() + Tab.MY_TICKET.getName());
        softAssert.assertTrue(loginPage.isDisplayed(Tab.CHANGE_PASSWORD), AssertMessage.ELEMENT_NOT_DISPLAYED.getMsg() + Tab.CHANGE_PASSWORD.getName());
        softAssert.assertTrue(loginPage.isDisplayed(Tab.LOGOUT), AssertMessage.ELEMENT_NOT_DISPLAYED.getMsg() + Tab.LOGOUT.getName());

        loginPage.clickTab(Tab.MY_TICKET);
        ExtentTestManager.logMessage("Expected: Click \"My ticket\" tab, user will be directed to My ticket page");
        softAssert.assertEquals(DriverManager.getCurrentUrl(), Url.RAILWAYS_MY_TICKET_URL.getUrlLink());

        loginPage.clickTab(Tab.CHANGE_PASSWORD);
        ExtentTestManager.logMessage("Expected: Click \"Change password\" tab, user will be directed to Change password page");
        softAssert.assertEquals(DriverManager.getCurrentUrl(), Url.RAILWAYS_CHANGE_PASSWORD_URL.getUrlLink());
        softAssert.assertAll();
    }
}
