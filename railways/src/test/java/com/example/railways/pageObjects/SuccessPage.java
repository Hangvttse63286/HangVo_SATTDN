package com.example.railways.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage {

    @FindBy(xpath = "//table[contains(@class,'WideTable')]")
    private WebElement loc_tblBookedTicket;

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getRowValue(String row) {
        return loc_tblBookedTicket.findElement(By.xpath("//td[count(//th[.='" + row + "']/preceding-sibling::th)+1]")).getText();
    }
}
