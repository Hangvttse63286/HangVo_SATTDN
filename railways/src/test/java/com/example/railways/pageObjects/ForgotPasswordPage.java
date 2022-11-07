package com.example.railways.pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ForgotPasswordPage extends BasePage{

    @FindBy(xpath = "//form//input[@id='email']")
    private WebElement loc_txtEmail;

    @FindBy(xpath = "//form//input[@type='submit']")
    private WebElement loc_btnSendInstruction;

    @FindBy(xpath = "//form//p[contains(@class,'error')]")
    private WebElement loc_msgError;

    @FindBy(xpath = "//form//label[@class='validation-error']")
    private WebElement loc_msgValidationError;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
}
