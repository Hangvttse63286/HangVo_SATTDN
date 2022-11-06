package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ConfirmPage extends BasePage{

    @FindBy(xpath = "//form//input[@id='confirmationCode']")
    private WebElement confirmTxt;

    @FindBy(xpath = "//form//input[@type='submit']")
    private WebElement confirmBtn;

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }
}
