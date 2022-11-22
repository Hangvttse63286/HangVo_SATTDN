package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URISyntaxException;
import java.util.List;

public class SuccessPage extends BasePage {

    private final By lblBookTicketSuccess = By.tagName("h1");
    private final By tblBookedTicket = By.xpath("//table[contains(@class,'WideTable')]");

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getLblBookTicketSuccess() {
        return driver.findElement(lblBookTicketSuccess);
    }

    private WebElement getTblBookedTicket() {
        return driver.findElement(tblBookedTicket);
    }

    public String getRowValue(String row) {
        return getTblBookedTicket().findElement(By.xpath("//td[count(//th[.='" + row + "']/preceding-sibling::th)+1]")).getText();
    }

    public String getLblBookTicketSuccessText() {
        return getLblBookTicketSuccess().getText();
    }

    public int getBookedTicketId() throws URISyntaxException {
        return Integer.parseInt(DriverManager.getParamValue("id"));
    }
}
