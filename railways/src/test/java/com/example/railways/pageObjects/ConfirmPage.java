package com.example.railways.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmPage extends BasePage {

    private final By txtConfirm = By.id("confirmationCode");
    private final By btnConfirm = By.id("//form//input[@type='submit']");

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxtConfirm() {
        return driver.findElement(txtConfirm);
    }

    private WebElement getBtnConfirm() {
        return driver.findElement(btnConfirm);
    }
}
