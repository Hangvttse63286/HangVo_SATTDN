package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

@Getter
public class LoginPage extends BasePage{

    @FindBy(xpath = "//form[@class='LoginForm']")
    private WebElement loginForm;

    @FindBy(xpath = "//form[@class='LoginForm']//input[@id='username']")
    private WebElement usernameTxt;

    @FindBy(xpath = "//form[@class='LoginForm']//input[@id='password']")
    private WebElement passwordTxt;

    @FindBy(xpath = "//form[@class='LoginForm']//input[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[contains(@href, 'Register')]")
    private WebElement registerLink;

    @FindBy(xpath = "//a[contains(@href, 'ForgotPassword')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//p[contains(@class,'error')]")
    private WebElement errorMsg;

    @FindBy(xpath = "//form[@class='LoginForm']//label[@for='username' and @class='validation-error']")
    private WebElement usernameValidationErrMsg;

    @FindBy(xpath = "//form[@class='LoginForm']//label[@for='password' and @class='validation-error']")
    private WebElement passwordValidationErrMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void login(String username, String password) {
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        loginBtn.click();
    }
}