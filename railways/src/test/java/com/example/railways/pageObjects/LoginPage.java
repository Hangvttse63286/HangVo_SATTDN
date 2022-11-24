package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By frmLogin = By.className("LoginForm");
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//form[@class='LoginForm']//input[@type='submit']");
    private final By lnkRegister = By.xpath("//a[contains(@href, 'Register')]");
    private final By lnkForgotPassword = By.xpath("//a[contains(@href, 'ForgotPassword')]");
    private final By lblError = By.xpath("//p[contains(@class,'error')]");
    private final By lblEmailValidationError = By.xpath("//form[@class='LoginForm']//label[@for='username' and @class='validation-error']");
    private final By lblPasswordValidationError = By.xpath("//form[@class='LoginForm']//label[@for='password' and @class='validation-error']");

    private WebElement getFrmLogin() {
        return DriverManager.findElement(frmLogin);
    }

    private WebElement getTxtEmail() {
        return DriverManager.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return DriverManager.findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverManager.findElement(btnLogin);
    }

    private WebElement getLnkRegister() {
        return DriverManager.findElement(lnkRegister);
    }

    private WebElement getLnkForgotPassword() {
        return DriverManager.findElement(lnkForgotPassword);
    }

    private WebElement getLblError() {
        return DriverManager.findElement(lblError);
    }

    private WebElement getLblEmailValidationError() {
        return DriverManager.findElement(lblEmailValidationError);
    }

    private WebElement getLblPasswordValidationError() {
        return DriverManager.findElement(lblPasswordValidationError);
    }

    public void login(String email, String password) {
        scrollToBtnLogin();
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }

    public String getLblErrorText() {
        return getLblError().getText();
    }

    public Boolean isLblErrorDisplayed() {
        try {
            return getLblError().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void scrollToBtnLogin() {
        DriverManager.scrollToView(getBtnLogin());
    }
}
