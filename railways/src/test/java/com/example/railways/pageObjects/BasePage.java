package com.example.railways.pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class BasePage {
    @FindBy(xpath = "//div[@id='menu']")
    private WebElement loc_mnuNavBar;

    @FindBy(xpath = "//div[@class='account']/strong[contains(., 'Welcome')]")
    private WebElement loc_lblWelcomeText;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getTab(String tab) {
        return loc_mnuNavBar.findElement(By.xpath("//span[.='" + tab + "']/.."));
    }

}