package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage {
    private final By tblBookedTicket = By.xpath("//table[contains(@class,'WideTable')]");

    private WebElement getTblBookedTicket() {
        return DriverManager.findElement(tblBookedTicket);
    }

    private WebElement getTicketElement(String col) {
        return getTblBookedTicket().findElement(By.xpath("//td[count(//th[.='" + col + "']/preceding-sibling::th)+1]"));
    }

    private String getTicketValue(String col) {
        return getTicketElement(col).getText();
    }

    public Long getTotalPrice() {
        DriverManager.scrollToView(getTicketElement("Total Price"));
        return Long.parseLong(getTicketValue("Total Price"));
    }
}
