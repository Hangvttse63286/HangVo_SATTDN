package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends BasePage{

    @FindBy(xpath = "//a[contains(@href,'Register')]")
    private WebElement registerLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
