package com.example.railways.pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'Register')]")
    private WebElement loc_lnkRegister;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
