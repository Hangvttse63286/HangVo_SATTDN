package com.example.railways.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    private final By txtEmail = By.id("email");
    private final By btnSendInstruction = By.xpath("//form//input[@type='submit']");
    private final By msgError = By.xpath("//form//p[contains(@class,'error')]");
    private final By msgValidationError = By.xpath("//form//label[@class='validation-error']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getTxtEmail() {
        return driver.findElement(txtEmail);
    }

    private WebElement getBtnSendInstruction() {
        return driver.findElement(btnSendInstruction);
    }

    private WebElement getMsgError() {
        return driver.findElement(msgError);
    }

    private WebElement getMsgValidationError() {
        return driver.findElement(msgValidationError);
    }
}
