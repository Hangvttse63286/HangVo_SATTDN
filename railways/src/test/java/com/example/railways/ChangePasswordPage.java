package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ChangePasswordPage extends BasePage{

    @FindBy(xpath = "//form[@id='ChangePW']")
    private WebElement changePasswordForm;

    @FindBy(xpath = "//form[@id='ChangePW']//input[@id='currentPassword']")
    private WebElement currentPasswordTxt;

    @FindBy(xpath = "//form[@id='ChangePW']//input[@id='newPassword']")
    private WebElement newPasswordTxt;

    @FindBy(xpath = "//form[@id='ChangePW']//input[@id='confirmPassword']")
    private WebElement confirmPasswordTxt;

    @FindBy(xpath = "//form[@id='ChangePW']//input[@type='submit']")
    private WebElement changePasswordBtn;

    @FindBy(xpath = "//form[@id='ChangePW']//p[contains(@class,'success')]")
    private WebElement successMsg;

    @FindBy(xpath = "//form[@id='ChangePW']//p[contains(@class,'error')]")
    private WebElement errorMsg;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='currentPassword' and @class='validation-error']")
    private WebElement currentPasswordValidationErrMsg;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='newPassword' and @class='validation-error']")
    private WebElement newPasswordValidationErrMsg;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='confirmPassword' and @class='validation-error']")
    private WebElement confirmPasswordValidationErrMsg;

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        currentPasswordTxt.sendKeys(currentPassword);
        newPasswordTxt.sendKeys(newPassword);
        confirmPasswordTxt.sendKeys(confirmPassword);
        changePasswordBtn.click();
    }
}
