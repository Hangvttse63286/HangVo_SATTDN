package com.example.railways.testcases.login;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_Login_InvalidPasswordSeveralTimes extends BaseTest {

    @Test
    public void TC_Login_InvalidPasswordSeveralTimes() {
        Log.info("TC05-System shows message when user enters wrong password several times");

        Log.info("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        Log.info("Click on \"Login\" tab");
        homePage.getTab(Tab.LOGIN).click();

        String email = getEmail();
        String password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        Log.info("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        Log.info("Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        Log.info("Click on \"Login\" button");
        Log.info("Repeat step 3 three more times.");
        for (int i = 0; i < 4; i++) {
            DriverManager.scrollToView(loginPage.getBtnLogin());
            loginPage.login(email, password);
        }
        Log.info("Expected: User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
        Assert.assertTrue(loginPage.getMsgError().isDisplayed());
        Assert.assertEquals(loginPage.getMsgError().getText(),
                "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
    }
}
