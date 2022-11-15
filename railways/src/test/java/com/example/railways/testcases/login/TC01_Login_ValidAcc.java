package com.example.railways.testcases.login;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.listenter.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class TC01_Login_ValidAcc extends BaseTest {

    @Test
    public void TC_Login_ValidAccount() {
        Log.info("TC01-User can log into Railway with valid username and password");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());

        Log.info("Click on \"Login\" tab");
        homePage.getTab(Tab.LOGIN).click();

        String email = getEmail();
        String password = getPassword();
        Log.info("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.scrollToView(loginPage.getBtnLogin());
        Log.info("Enter valid Email and Password");
        Log.info("Click on \"Login\" button");
        loginPage.login(email, password);
        String welcomeText = loginPage.getLblWelcomeText().getText().trim();

        Log.info("Expected: User is logged into Railway. Welcome user message is displayed.");
        Assert.assertEquals(welcomeText, "Welcome " + email);
    }
}
