package com.example.railways;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

@Getter
public class BasePage {
    @FindBy(xpath = "//div[@id='menu']")
    private WebElement navBar;

    @FindBy(xpath = "//div[@class='account']/strong[contains(., 'Welcome')]")
    private WebElement welcomeText;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getTab(String tab) {
            return navBar.findElement(By.xpath("//span[.='" + tab + "']/.."));
    }

}