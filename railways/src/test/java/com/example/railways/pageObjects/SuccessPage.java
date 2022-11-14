package com.example.railways.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage {

    private final By msgBookTicketSuccess = By.tagName("h1");
    private final By tblBookedTicket = By.xpath("//table[contains(@class,'WideTable')]");

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMsgBookTicketSuccess() {
        return driver.findElement(msgBookTicketSuccess);
    }

    public WebElement getTblBookedTicket() {
        return driver.findElement(tblBookedTicket);
    }

    public String getRowValue(String row) {
        return getTblBookedTicket().findElement(By.xpath("//td[count(//th[.='" + row + "']/preceding-sibling::th)+1]")).getText();
    }
}
