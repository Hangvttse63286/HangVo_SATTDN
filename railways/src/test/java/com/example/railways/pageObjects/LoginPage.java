package com.example.railways.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By frmLogin = By.className("LoginForm");
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//form[@class='LoginForm']//input[@type='submit']");
    private final By lnkRegister = By.xpath("//a[contains(@href, 'Register')]");
    private final By lnkForgotPassword = By.xpath("//a[contains(@href, 'ForgotPassword')]");
    private final By msgError = By.xpath("//p[contains(@class,'error')]");
    private final By msgEmailValidationError = By.xpath("//form[@class='LoginForm']//label[@for='username' and @class='validation-error']");
    private final By msgPasswordValidationError = By.xpath("//form[@class='LoginForm']//label[@for='password' and @class='validation-error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFrmLogin() {
        return driver.findElement(frmLogin);
    }

    public WebElement getTxtEmail() {
        return driver.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return driver.findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return driver.findElement(btnLogin);
    }

    public WebElement getLnkRegister() {
        return driver.findElement(lnkRegister);
    }

    public WebElement getLnkForgotPassword() {
        return driver.findElement(lnkForgotPassword);
    }

    public WebElement getMsgError() {
        return driver.findElement(msgError);
    }

    public WebElement getMsgEmailValidationError() {
        return driver.findElement(msgEmailValidationError);
    }

    public WebElement getMsgPasswordValidationError() {
        return driver.findElement(msgPasswordValidationError);
    }

    public void login(String email, String password) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }
}
