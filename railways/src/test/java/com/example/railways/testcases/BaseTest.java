package com.example.railways.testcases;

import com.example.railways.common.constant.Tab;
import com.example.railways.common.constant.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.pageObjects.RegisterPage;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Parameters({"browserType"})
    @BeforeTest
    public void initializeTestBaseSetup(String browserType) {
        try {
            DriverManager.setDriver(browserType);
            DriverManager.maximizeWindow();
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @BeforeMethod
    public void openWebsite() {
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
        DriverManager.pageLoadTimeout(TimeUnit.SECONDS);
        DriverManager.implicitlyWait(TimeUnit.SECONDS);

        RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
        registerPage.getTab(Tab.REGISTER).click();

        email = Utilities.generateRandomEmail(Utilities.getRandomNumber(6, 32));
        password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        String pid = Utilities.generateRandomString(Utilities.getRandomNumber(8, 20));
        DriverManager.scrollToView(registerPage.getBtnRegister());
        registerPage.register(email, password, password, pid);
    }

    @AfterMethod
    public void clearAllCookies() {
        DriverManager.clearAllCookies();
    }

    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        DriverManager.quit();
    }
}

