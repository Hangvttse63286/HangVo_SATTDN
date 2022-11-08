package com.example.railways.pageObjects;

import com.example.railways.common.constant.Constant;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

    @FindBy(xpath = "//form[@class='LoginForm']")
    private WebElement loc_frmLogin;

    @FindBy(xpath = "//form[@class='LoginForm']//input[@id='username']")
    private WebElement loc_txtEmail;

    @FindBy(xpath = "//form[@class='LoginForm']//input[@id='password']")
    private WebElement loc_txtPassword;

    @FindBy(xpath = "//form[@class='LoginForm']//input[@type='submit']")
    private WebElement loc_btnLogin;

    @FindBy(xpath = "//a[contains(@href, 'Register')]")
    private WebElement loc_lnkRegister;

    @FindBy(xpath = "//a[contains(@href, 'ForgotPassword')]")
    private WebElement loc_lnkForgotPassword;

    @FindBy(xpath = "//p[contains(@class,'error')]")
    private WebElement loc_msgError;

    @FindBy(xpath = "//form[@class='LoginForm']//label[@for='username' and @class='validation-error']")
    private WebElement loc_msgEmailValidationError;

    @FindBy(xpath = "//form[@class='LoginForm']//label[@for='password' and @class='validation-error']")
    private WebElement loc_msgPasswordValidationError;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        loc_txtEmail.sendKeys(email);
        loc_txtPassword.sendKeys(password);
        loc_btnLogin.click();
    }

    public void loginWithValidAcc() {
        loc_txtEmail.sendKeys(Constant.EMAIL);
        loc_txtPassword.sendKeys(Constant.PASSWORD);
        loc_btnLogin.click();
    }
}