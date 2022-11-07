package com.example.railways.pageObjects;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterPage extends BasePage {

    @FindBy(xpath = "//form[@id='RegisterForm']")
    private WebElement loc_frmRegister;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@id='email']")
    private WebElement loc_txtEmail;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@id='password']")
    private WebElement loc_txtPassword;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@id='confirmPassword']")
    private WebElement loc_txtConfirmPassword;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@id='pid']")
    private WebElement loc_txtPid;

    @FindBy(xpath = "//form[@id='RegisterForm']//input[@type='submit']")
    private WebElement loc_btnRegister;

    @FindBy(xpath = "//a[contains(@href, 'Login')]")
    private WebElement loc_lnkLogin;

    @FindBy(xpath = "//a[contains(@href, 'Confirm')]")
    private WebElement loc_lnkConfirm;

    @FindBy(xpath = "//p[contains(@class,'error')]")
    private WebElement loc_msgError;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='email' and @class='validation-error']")
    private WebElement loc_msgEmailValidationError;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='password' and @class='validation-error']")
    private WebElement loc_msgPasswordValidationError;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='confirmPassword' and @class='validation-error']")
    private WebElement loc_msgConfirmPasswordValidationError;

    @FindBy(xpath = "//form[@class='RegisterForm']//label[@for='pid' and @class='validation-error']")
    private WebElement loc_msgPidValidationError;

    private JavascriptExecutor js;

    public RegisterPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public void register(String email, String password, String confirmPassword, String pid) {
        loc_txtEmail.sendKeys(email);
        loc_txtPassword.sendKeys(password);
        loc_txtConfirmPassword.sendKeys(confirmPassword);
        loc_txtPid.sendKeys(pid);

        js.executeScript("arguments[0].scrollIntoView();", loc_btnRegister);
        loc_btnRegister.click();
    }
}
