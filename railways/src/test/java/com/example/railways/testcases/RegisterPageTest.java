package com.example.railways.testcases;

import com.example.railways.common.constant.Constant;
import com.example.railways.common.constant.Tab;
import com.example.railways.common.utilities.BaseSetup;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.pageObjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseSetup {

    WebDriver driver;
    RegisterPage registerPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();

    }

    @Test
    public void TC_001_Register_ExistedEmail() {
        String email = Constant.EMAIL;
        String password = Utilities.generateRandomString(8);
        String confirmPassword = password;
        String pid = Utilities.generateRandomString(8);

        registerPage.getTab(Tab.REGISTER.getName()).click();

        registerPage.register(email, password, confirmPassword, pid);
        Assert.assertTrue(registerPage.getLoc_msgError().isDisplayed());
    }
}