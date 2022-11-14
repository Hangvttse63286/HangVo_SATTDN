package com.example.railways.pageObjects;

import com.example.railways.common.constant.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    private final By lblWelcomeText = By.xpath("//div[@class='account']/strong[contains(., 'Welcome')]");
    private final String tabXPath = "//div[@id='menu']//span[.='%s']/..";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLblWelcomeText() {
        return driver.findElement(lblWelcomeText);
    }

    public WebElement getTab(Tab tab) {
        return driver.findElement(By.xpath(String.format(tabXPath, tab.getName())));
    }
}
