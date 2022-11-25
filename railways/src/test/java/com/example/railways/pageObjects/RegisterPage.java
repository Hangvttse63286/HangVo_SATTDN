package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private final By frmRegister = By.id("RegisterForm");
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//form[@id='RegisterForm']//input[@type='submit']");
    private final By lnkLogin = By.xpath("//a[contains(@href, 'Login')]");
    private final By lnkConfirm = By.xpath("//a[contains(@href, 'Confirm')]");
    private final By lblSuccess = By.xpath("//div[@id='content']/p");
    private final By lblError = By.xpath("//p[contains(@class,'error')]");
    private final By lblEmailError = By.xpath("//form[@id='RegisterForm']//label[@for='email' and @class='validation-error']");
    private final By lblPasswordError = By.xpath("//form[@id='RegisterForm']//label[@for='password' and @class='validation-error']");
    private final By lblConfirmPasswordError = By.xpath("//form[@id='RegisterForm']//label[@for='confirmPassword' and @class='validation-error']");
    private final By lblPidError = By.xpath("//form[@id='RegisterForm']//label[@for='pid' and @class='validation-error']");
}
