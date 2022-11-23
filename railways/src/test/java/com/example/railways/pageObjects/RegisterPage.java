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
    private final By lblSuccess = By.xpath("//div[@id='content']/p");
    private final By lblError = By.xpath("//p[contains(@class,'error')]");
    private final By lblEmailError = By.xpath("//form[@id='RegisterForm']//label[@for='email' and @class='validation-error']");
    private final By lblPasswordError = By.xpath("//form[@id='RegisterForm']//label[@for='password' and @class='validation-error']");
    private final By lblConfirmPasswordError = By.xpath("//form[@id='RegisterForm']//label[@for='confirmPassword' and @class='validation-error']");
    private final By lblPidError = By.xpath("//form[@id='RegisterForm']//label[@for='pid' and @class='validation-error']");

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

    private WebElement getLblSuccess() {
        return driver.findElement(lblSuccess);
    }

    private WebElement getLblError() {
        return driver.findElement(lblError);
    }

    private WebElement getLblEmailError() {
        return driver.findElement(lblEmailError);
    }

    private WebElement getLblPasswordError() {
        return driver.findElement(lblPasswordError);
    }

    private WebElement getLblConfirmPasswordError() {
        return driver.findElement(lblConfirmPasswordError);
    }

    private WebElement getLblPidError() {
        return driver.findElement(lblPidError);
    }

    public void register(String email, String password, String confirmPassword, String pid) {
        scrollToBtnRegister();
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPid().sendKeys(pid);
        getBtnRegister().click();
    }

    public void scrollToBtnRegister() {
        DriverManager.scrollToView(getBtnRegister());
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

    public String getLblPasswordErrorText() {
        return getLblPasswordError().getText();
    }

    public Boolean isLblPasswordErrorDisplayed() {
        try {
            return getLblPasswordError().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getLblPidErrorText() {
        return getLblPidError().getText();
    }

    public Boolean isLblPidErrorDisplayed() {
        try {
            return getLblPidError().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
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
}
