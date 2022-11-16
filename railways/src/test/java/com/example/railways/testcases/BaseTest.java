package com.example.railways.testcases;

import com.example.railways.dataObjects.Tab;
import com.example.railways.dataObjects.Url;
import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.common.utilities.helpers.ConfigFileReader;
import com.example.railways.pageObjects.RegisterPage;
import org.testng.annotations.*;
import java.util.Arrays;

public class BaseTest {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @BeforeTest
    public void initializeTestBaseSetup() {
        try {
            ConfigFileReader.setConfigFileReader();
            DriverManager.setDriver();
            DriverManager.maximizeWindow();
        } catch (Exception e) {
            Log.error("Error..." + Arrays.toString(e.getStackTrace()));
        }
    }

    @BeforeMethod
    public void setUp() {
        DriverManager.open(Url.RAILWAYS_URL.getUrlLink());
        DriverManager.pageLoadTimeout();
        DriverManager.implicitlyWait();

        RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
        registerPage.clickTab(Tab.REGISTER);

        email = Utilities.generateRandomEmail(Utilities.getRandomNumber(6, 32));
        password = Utilities.generateRandomString(Utilities.getRandomNumber(8, 64));
        String pid = Utilities.generateRandomString(Utilities.getRandomNumber(8, 20));
        registerPage.scrollToBtnRegister();
        registerPage.register(email, password, password, pid);
    }

    @AfterMethod
    public void clearAllCookies() {
        DriverManager.clearAllCookies();
    }

    @AfterTest
    public void tearDown() {
        try {
            Thread.sleep(2000);
            DriverManager.quit();
        } catch (Exception e) {
            Log.error("Error..." + Arrays.toString(e.getStackTrace()));
        }
    }
}

