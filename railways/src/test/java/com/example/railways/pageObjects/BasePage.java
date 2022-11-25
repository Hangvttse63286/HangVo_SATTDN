package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import com.example.railways.dataObjects.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BasePage {
    private final By lblWelcomeText = By.xpath("//div[@class='account']/strong[contains(., 'Welcome')]");
    private final String tabXPath = "//div[@id='menu']//span[.='%s']/..";
}
