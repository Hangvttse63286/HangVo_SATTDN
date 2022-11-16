package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By frmLogin = By.className("LoginForm");
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//form[@class='LoginForm']//input[@type='submit']");
    private final By lnkRegister = By.xpath("//a[contains(@href, 'Register')]");
    private final By lnkForgotPassword = By.xpath("//a[contains(@href, 'ForgotPassword')]");
    private final By msgError = By.xpath("//p[contains(@class,'error')]");
    private final By msgEmailValidationError = By.xpath("//form[@class='LoginForm']//label[@for='username' and @class='validation-error']");
    private final By msgPasswordValidationError = By.xpath("//form[@class='LoginForm']//label[@for='password' and @class='validation-error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getFrmLogin() {
        return driver.findElement(frmLogin);
    }

    private WebElement getTxtEmail() {
        return driver.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return driver.findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return driver.findElement(btnLogin);
    }

    private WebElement getLnkRegister() {
        return driver.findElement(lnkRegister);
    }

    private WebElement getLnkForgotPassword() {
        return driver.findElement(lnkForgotPassword);
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

    public void login(String email, String password) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
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

    public void scrollToBtnLogin() {
        DriverManager.scrollToView(getBtnLogin());
    }
}
