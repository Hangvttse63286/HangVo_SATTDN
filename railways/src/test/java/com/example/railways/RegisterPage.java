package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterPage extends BasePage{

    @FindBy(xpath = "//form[@id='RegisterForm']")
    private WebElement registerForm;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@id='email']")
    private WebElement emailTxt;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@id='password']")
    private WebElement passwordTxt;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@id='confirmPassword']")
    private WebElement confirmPasswordTxt;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@id='pid']")
    private WebElement pidTxt;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@type='submit']")
    private WebElement registerBtn;

    @FindBy(xpath = "//a[contains(@href, 'Login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//a[contains(@href, 'Confirm')]")
    private WebElement confirmLink;

    @FindBy(xpath = "//p[contains(@class,'error')]")
    private WebElement errorMsg;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='email' and @class='validation-error']")
    private WebElement emailValidationErrMsg;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='password' and @class='validation-error']")
    private WebElement passwordValidationErrMsg;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='confirmPassword' and @class='validation-error']")
    private WebElement confirmPasswordValidationErrMsg;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='pid' and @class='validation-error']")
    private WebElement pidValidationErrMsg;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickConfirmLink() {
        confirmLink.click();
    }

    public void register(String email, String password, String confirmPassword, String pid) {
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(password);
        pidTxt.sendKeys(password);
        registerBtn.click();
    }
}
