package com.example.railways.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    private final By msgSuccess = By.xpath("//div[@id='content']/p");
    private final By msgError = By.xpath("//p[contains(@class,'error')]");
    private final By msgEmailValidationError = By.xpath("//form[@id='RegisterForm']//label[@for='email' and @class='validation-error']");
    private final By msgPasswordValidationError = By.xpath("//form[@id='RegisterForm']//label[@for='password' and @class='validation-error']");
    private final By msgConfirmPasswordValidationError = By.xpath("//form[@id='RegisterForm']//label[@for='confirmPassword' and @class='validation-error']");
    private final By msgPidValidationError = By.xpath("//form[@id='RegisterForm']//label[@for='pid' and @class='validation-error']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFrmRegister() {
        return driver.findElement(frmRegister);
    }

    public WebElement getTxtEmail() {
        return driver.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return driver.findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return driver.findElement(txtConfirmPassword);
    }

    public WebElement getTxtPid() {
        return driver.findElement(txtPid);
    }

    public WebElement getBtnRegister() {
        return driver.findElement(btnRegister);
    }

    public WebElement getLnkLogin() {
        return driver.findElement(lnkLogin);
    }

    public WebElement getLnkConfirm() {
        return driver.findElement(lnkConfirm);
    }

    public WebElement getMsgSuccess() {
        return driver.findElement(msgSuccess);
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

    public WebElement getMsgConfirmPasswordValidationError() {
        return driver.findElement(msgConfirmPasswordValidationError);
    }

    public WebElement getMsgPidValidationError() {
        return driver.findElement(msgPidValidationError);
    }

    public void register(String email, String password, String confirmPassword, String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPid().sendKeys(pid);
        getBtnRegister().click();
    }
}
