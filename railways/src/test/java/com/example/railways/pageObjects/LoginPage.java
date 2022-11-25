package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By frmLogin = By.className("LoginForm");
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//form[@class='LoginForm']//input[@type='submit']");
    private final By lnkRegister = By.xpath("//a[contains(@href, 'Register')]");
    private final By lnkForgotPassword = By.xpath("//a[contains(@href, 'ForgotPassword')]");
    private final By lblError = By.xpath("//p[contains(@class,'error')]");
    private final By lblEmailValidationError = By.xpath("//form[@class='LoginForm']//label[@for='username' and @class='validation-error']");
    private final By lblPasswordValidationError = By.xpath("//form[@class='LoginForm']//label[@for='password' and @class='validation-error']");
}
