package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import com.example.railways.dataObjects.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TicketPricePage extends BasePage {
    private final By tblTicketPriceList = By.xpath("//table[contains(@class,'NoBorder')]");
    private final By btnCheckPrices = By.xpath("//table[contains(@class,'NoBorder')]//a[contains(@href,'Price')]");
    private final By tblTicketPrice = By.xpath("//table[contains(@class,'MedTable')]");
    private final By thTrain = By.xpath("//table[contains(@class,'MedTable')]//tr[@class='TableSmallHeader']/th");
    private final By tblSeat = By.xpath("//table[contains(@class,'NoBorder')]");
    private final By btnBookTickets = By.xpath("//table[contains(@class,'NoBorder')]//a[contains(@href,'Book')]");
}
