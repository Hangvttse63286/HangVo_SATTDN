package com.example.railways.pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ChangePasswordPage extends BasePage {

    @FindBy(xpath = "//form[@id='ChangePW']")
    private WebElement loc_frmChangePassword;

    @FindBy(xpath = "//form[@id='ChangePW']//input[@id='currentPassword']")
    private WebElement loc_txtCurrentPassword;

    @FindBy(xpath = "//form[@id='ChangePW']//input[@id='newPassword']")
    private WebElement loc_txtNewPassword;

    @FindBy(xpath = "//form[@id='ChangePW']//input[@id='confirmPassword']")
    private WebElement loc_txtConfirmPassword;

    @FindBy(xpath = "//form[@id='ChangePW']//input[@type='submit']")
    private WebElement loc_btnChangePassword;

    @FindBy(xpath = "//form[@id='ChangePW']//p[contains(@class,'success')]")
    private WebElement loc_msgSuccess;

    @FindBy(xpath = "//form[@id='ChangePW']//p[contains(@class,'error')]")
    private WebElement loc_msgError;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='currentPassword' and @class='validation-error']")
    private WebElement loc_msgCurrentPasswordValidationError;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='newPassword' and @class='validation-error']")
    private WebElement loc_msgNewPasswordValidationError;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='confirmPassword' and @class='validation-error']")
    private WebElement loc_msgConfirmPasswordValidationError;

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        loc_txtCurrentPassword.sendKeys(currentPassword);
        loc_txtNewPassword.sendKeys(newPassword);
        loc_txtConfirmPassword.sendKeys(confirmPassword);
        loc_btnChangePassword.click();
    }
}
