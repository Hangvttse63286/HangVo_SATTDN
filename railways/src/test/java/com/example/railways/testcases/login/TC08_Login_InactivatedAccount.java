package com.example.railways.testcases.login;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.constant.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08_Login_InactivatedAccount extends BaseTest {

    @Test
    public void TC_Login_InactivatedAccount() {
        Log.info("TC08-User can't login with an account hasn't been activated");
        Log.info("Pre-condition: Create a new account but do not activate it");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Click on \"Login\" tab");
        homePage.getTab(Tab.LOGIN).click();

        String email = getEmail();
        String password = getPassword();
        Log.info("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        Log.info("Enter username and password of account hasn't been activated.");
        Log.info("Click on \"Login\" button");
        loginPage.login(email, password);

        Log.info("Expected: User can't login and message \"Invalid username or password. Please try again.\" appears.");
        String welcomeText = loginPage.getLblWelcomeText().getText().trim();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), Url.RAILWAYS_LOGIN_URL.getUrlLink());
        Assert.assertEquals(welcomeText, "Welcome guest!");
        Assert.assertEquals(loginPage.getMsgError().getText(), "Invalid username or password. Please try again.");
    }
}
