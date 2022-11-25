package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.URISyntaxException;

public class SuccessPage extends BasePage {
    private final By lblBookTicketSuccess = By.tagName("h1");
    private final By tblBookedTicket = By.xpath("//table[contains(@class,'WideTable')]");
}
