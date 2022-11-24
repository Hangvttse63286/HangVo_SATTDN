package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private final By lnkRegister = By.xpath("//a[contains(@href,'Register')]");

    private WebElement getLnkRegister() {
        return DriverManager.findElement(lnkRegister);
    }
}
