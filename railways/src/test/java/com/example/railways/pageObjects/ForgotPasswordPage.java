package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {
    private final By txtEmail = By.id("email");
    private final By btnSendInstruction = By.xpath("//form//input[@type='submit']");
    private final By lblError = By.xpath("//form//p[contains(@class,'error')]");
    private final By lblValidationError = By.xpath("//form//label[@class='validation-error']");

    private WebElement getTxtEmail() {
        return DriverManager.findElement(txtEmail);
    }

    private WebElement getBtnSendInstruction() {
        return DriverManager.findElement(btnSendInstruction);
    }

    private WebElement getLblError() {
        return DriverManager.findElement(lblError);
    }

    private WebElement getLblValidationError() {
        return DriverManager.findElement(lblValidationError);
    }
}
