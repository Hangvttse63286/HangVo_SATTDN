package com.example.railways.testcases.login;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.constant.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.listenter.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class TC06_Login_AdditionalPagesDisplay extends BaseTest {

    @Test
    public void TC_Login_ValidAccount_AdditionalPagesDisplay() {
        Log.info("TC06-Additional pages display once user logged in");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Click on \"Login\" tab");
        homePage.getTab(Tab.LOGIN).click();

        String email = getEmail();
        String password = getPassword();
        Log.info("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        Log.info("Login with valid account");
        loginPage.login(email, password);

        Log.info("Expected: \"My ticket\", \"Change password\" and \"Logout\" tabs are displayed. ");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.getTab(Tab.MY_TICKET).isDisplayed());
        softAssert.assertTrue(loginPage.getTab(Tab.CHANGE_PASSWORD).isDisplayed());
        softAssert.assertTrue(loginPage.getTab(Tab.LOGOUT).isDisplayed());

        loginPage.getTab(Tab.MY_TICKET).click();
        Log.info("Expected: Click \"My ticket\" tab, user will be directed to My ticket page");
        softAssert.assertEquals(DriverManager.getCurrentUrl(), Url.RAILWAYS_MY_TICKET_URL.getUrlLink());

        loginPage.getTab(Tab.CHANGE_PASSWORD).click();
        Log.info("Expected: Click \"Change password\" tab, user will be directed to Change password page");
        softAssert.assertEquals(DriverManager.getCurrentUrl(), Url.RAILWAYS_CHANGE_PASSWORD_URL.getUrlLink());
        softAssert.assertAll();
    }
}
