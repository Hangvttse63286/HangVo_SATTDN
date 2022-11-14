package com.example.railways.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final By lnkRegister = By.xpath("//a[contains(@href,'Register')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLnkRegister() {
        return driver.findElement(lnkRegister);
    }
}
