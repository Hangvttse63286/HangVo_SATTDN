package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ForgotPasswordPage extends BasePage{

    @FindBy(xpath = "//form//input[@id='email']")
    private WebElement emailTxt;

    @FindBy(xpath = "//form//input[@type='submit']")
    private WebElement sendInstructionBtn;

    @FindBy(xpath = "//form//p[contains(@class,'error')]")
    private WebElement errorMsg;

    @FindBy(xpath = "//form//label[@class='validation-error']")
    private WebElement validationErrMsg;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
}
