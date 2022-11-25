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

    private WebElement getTxtEmail() {
        return DriverManager.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return DriverManager.findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverManager.findElement(btnLogin);
    }

    public void login(String email, String password) {
        scrollToBtnLogin();
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }

    public void scrollToBtnLogin() {
        DriverManager.scrollToView(getBtnLogin());
    }
}
