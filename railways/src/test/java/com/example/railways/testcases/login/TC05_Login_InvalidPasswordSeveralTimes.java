package com.example.railways.testcases.login;

import com.example.railways.dataObjects.Message;
import com.example.railways.dataObjects.Tab;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.extentreports.ExtentTestManager;
import com.example.railways.common.utilities.listener.ReportListener;
import com.example.railways.pageObjects.HomePage;
import com.example.railways.pageObjects.LoginPage;
import com.example.railways.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class TC05_Login_InvalidPasswordSeveralTimes extends BaseTest {

    @Test
    public void TC_Login_InvalidPasswordSeveralTimes() {
        ExtentTestManager.logMessage("TC05-System shows message when user enters wrong password several times");

        ExtentTestManager.logMessage("Navigate to QA Railway Website");
        HomePage homePage = new HomePage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Click on \"Login\" tab");
        homePage.clickTab(Tab.LOGIN);

        String email = getEmail();
        String password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        ExtentTestManager.logMessage("Email: " + email + " - Password: " + password);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        ExtentTestManager.logMessage("Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        ExtentTestManager.logMessage("Click on \"Login\" button");
        ExtentTestManager.logMessage("Repeat step 3 three more times.");
        for (int i = 0; i < 4; i++) {
            loginPage.scrollToBtnLogin();
            loginPage.login(email, password);
        }
        ExtentTestManager.logMessage("Expected: User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
        Assert.assertTrue(loginPage.isExistedLblError());
        Assert.assertEquals(loginPage.getLblErrorText(), Message.LOGIN_FAILED_SEVERAL_TIMES.getMsg());
    }
}
