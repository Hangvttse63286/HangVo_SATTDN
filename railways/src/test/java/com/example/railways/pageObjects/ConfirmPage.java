package com.example.railways.pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ConfirmPage extends BasePage {

    @FindBy(xpath = "//form//input[@id='confirmationCode']")
    private WebElement loc_txtConfirm;

    @FindBy(xpath = "//form//input[@type='submit']")
    private WebElement loc_btnConfirm;

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }
}
