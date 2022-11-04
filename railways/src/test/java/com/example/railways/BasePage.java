package com.example.railways;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = http://www.railwayb2.somee.com/
public class BasePage {

    @FindBy(xpath = "//div[@id='menu']")
    private WebElement navBar;

    @FindBy(xpath = "//div[@class='account']/strong[contains(., 'Welcome')]")
    private WebElement welcomeText;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigate(String tab) {
            navBar.findElement(By.xpath("//span[.='" + tab + "']/..")).click();
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public Boolean isDisplayedTab(String tab) {
        return navBar.findElement(By.xpath("//span[.='" + tab + "']/..")).isDisplayed();
    }


}