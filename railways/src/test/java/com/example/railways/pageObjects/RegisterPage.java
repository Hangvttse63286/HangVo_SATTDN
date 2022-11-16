package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    private WebElement getFrmRegister() {
        return driver.findElement(frmRegister);
    }

    private WebElement getTxtEmail() {
        return driver.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return driver.findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return driver.findElement(txtConfirmPassword);
    }

    private WebElement getTxtPid() {
        return driver.findElement(txtPid);
    }

    private WebElement getBtnRegister() {
        return driver.findElement(btnRegister);
    }

    private WebElement getLnkLogin() {
        return driver.findElement(lnkLogin);
    }

    private WebElement getLnkConfirm() {
        return driver.findElement(lnkConfirm);
    }

    private WebElement getMsgSuccess() {
        return driver.findElement(msgSuccess);
    }

    private WebElement getMsgError() {
        return driver.findElement(msgError);
    }

    private WebElement getMsgEmailValidationError() {
        return driver.findElement(msgEmailValidationError);
    }

    private WebElement getMsgPasswordValidationError() {
        return driver.findElement(msgPasswordValidationError);
    }

    private WebElement getMsgConfirmPasswordValidationError() {
        return driver.findElement(msgConfirmPasswordValidationError);
    }

    private WebElement getMsgPidValidationError() {
        return driver.findElement(msgPidValidationError);
    }

    public void register(String email, String password, String confirmPassword, String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPid().sendKeys(pid);
        getBtnRegister().click();
    }

    public void scrollToBtnRegister() {
        DriverManager.scrollToView(getBtnRegister());
    }

    public String getMsgSuccessText() {
        return getMsgSuccess().getText();
    }

    public Boolean isExistedMsgSuccess() {
        try{
            getMsgSuccess();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public String getMsgPasswordValidationErrorText() {
        return getMsgPasswordValidationError().getText();
    }

    public Boolean isExistedMsgPasswordValidationError() {
        try{
            getMsgPasswordValidationError();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public String getMsgPidValidationErrorText() {
        return getMsgPidValidationError().getText();
    }

    public Boolean isExistedMsgPidValidationError() {
        try{
            getMsgPidValidationError();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public String getMsgErrorText() {
        return getMsgError().getText();
    }

    public Boolean isExistedMsgError() {
        try{
            getMsgError();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}
