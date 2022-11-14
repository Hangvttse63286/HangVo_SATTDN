package com.example.railways.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    private final By frmChangePassword = By.id("ChangePW");
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//form[@id='ChangePW']//input[@type='submit']");
    private final By msgSuccess = By.xpath("//form[@id='ChangePW']//p[contains(@class,'success')]");
    private final By msgError = By.xpath("//form[@id='ChangePW']//p[contains(@class,'error')]");
    private final By msgCurrentPasswordValidationError = By.xpath("//form[@class='RegisterForm']//label[@for='currentPassword' and @class='validation-error']");
    private final By msgNewPasswordValidationError = By.xpath("//form[@class='RegisterForm']//label[@for='newPassword' and @class='validation-error']");
    private final By msgConfirmPasswordValidationError = By.xpath("//form[@class='RegisterForm']//label[@for='confirmPassword' and @class='validation-error']");

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFrmChangePassword() {
        return driver.findElement(frmChangePassword);
    }

    public WebElement getTxtCurrentPassword() {
        return driver.findElement(txtCurrentPassword);
    }

    public WebElement getTxtNewPassword() {
        return driver.findElement(txtNewPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return driver.findElement(txtConfirmPassword);
    }

    public WebElement getBtnChangePassword() {
        return driver.findElement(btnChangePassword);
    }

    public WebElement getMsgSuccess() {
        return driver.findElement(msgSuccess);
    }

    public WebElement getMsgError() {
        return driver.findElement(msgError);
    }

    public WebElement getMsgCurrentPasswordValidationError() {
        return driver.findElement(msgCurrentPasswordValidationError);
    }

    public WebElement getMsgNewPasswordValidationError() {
        return driver.findElement(msgNewPasswordValidationError);
    }

    public WebElement getMsgConfirmPasswordValidationError() {
        return driver.findElement(msgConfirmPasswordValidationError);
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        getTxtCurrentPassword().sendKeys(currentPassword);
        getTxtNewPassword().sendKeys(newPassword);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getBtnChangePassword().click();
    }
}
