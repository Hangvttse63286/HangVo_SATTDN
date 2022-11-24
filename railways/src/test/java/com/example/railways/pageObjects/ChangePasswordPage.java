package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {
    private final By frmChangePassword = By.id("ChangePW");
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//form[@id='ChangePW']//input[@type='submit']");
    private final By lblSuccess = By.xpath("//form[@id='ChangePW']//p[contains(@class,'success')]");
    private final By lblError = By.xpath("//form[@id='ChangePW']//p[contains(@class,'error')]");
    private final By lblCurrentPasswordValidationError = By.xpath("//form[@class='RegisterForm']//label[@for='currentPassword' and @class='validation-error']");
    private final By msgNewPasswordValidationError = By.xpath("//form[@class='RegisterForm']//label[@for='newPassword' and @class='validation-error']");
    private final By msgConfirmPasswordValidationError = By.xpath("//form[@class='RegisterForm']//label[@for='confirmPassword' and @class='validation-error']");

    private WebElement getFrmChangePassword() {
        return DriverManager.findElement(frmChangePassword);
    }

    private WebElement getTxtCurrentPassword() {
        return DriverManager.findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword() {
        return DriverManager.findElement(txtNewPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverManager.findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword() {
        return DriverManager.findElement(btnChangePassword);
    }

    private WebElement getLblSuccess() {
        return DriverManager.findElement(lblSuccess);
    }

    private WebElement getLblError() {
        return DriverManager.findElement(lblError);
    }

    private WebElement getLblCurrentPasswordValidationError() {
        return DriverManager.findElement(lblCurrentPasswordValidationError);
    }

    public WebElement getMsgNewPasswordValidationError() {
        return DriverManager.findElement(msgNewPasswordValidationError);
    }

    public WebElement getMsgConfirmPasswordValidationError() {
        return DriverManager.findElement(msgConfirmPasswordValidationError);
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        getTxtCurrentPassword().sendKeys(currentPassword);
        getTxtNewPassword().sendKeys(newPassword);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getBtnChangePassword().click();
    }

    public String getLblSuccessText() {
        return getLblSuccess().getText();
    }

    public Boolean isLblSuccessDisplayed() {
        try {
            return getLblSuccess().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void scrollToBtnChangePassword() {
        DriverManager.scrollToView(getBtnChangePassword());
    }
}
