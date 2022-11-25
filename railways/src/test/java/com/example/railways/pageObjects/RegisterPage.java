package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//form[@id='RegisterForm']//input[@type='submit']");

    private WebElement getTxtEmail() {
        return DriverManager.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return DriverManager.findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverManager.findElement(txtConfirmPassword);
    }

    private WebElement getTxtPid() {
        return DriverManager.findElement(txtPid);
    }

    private WebElement getBtnRegister() {
        return DriverManager.findElement(btnRegister);
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
}
