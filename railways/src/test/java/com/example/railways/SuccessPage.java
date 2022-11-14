package com.example.railways;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage{

    @FindBy(xpath = "//table[contains(@class,'WideTable')]")
    private WebElement bookedTicketTbl;

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getRowValue (String row) {
        return bookedTicketTbl.findElement(By.xpath("//td[count(//th[.='"+row+"']/preceding-sibling::th)+1]")).getText();
    }
}
