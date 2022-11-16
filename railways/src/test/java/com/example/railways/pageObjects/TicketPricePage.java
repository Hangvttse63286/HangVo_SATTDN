package com.example.railways.pageObjects;

import com.example.railways.dataObjects.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TicketPricePage extends BasePage {

    private final By tblTicketPriceList = By.xpath("//table[contains(@class,'NoBorder')]");
    private final By btnCheckPrices = By.xpath("//table[contains(@class,'NoBorder')]//a[contains(@href,'Price')]");
    private final By tblTicketPrice = By.xpath("//table[contains(@class,'MedTable')]");
    private final By thTrain = By.xpath("//table[contains(@class,'MedTable')]//tr[@class='TableSmallHeader']/th");
    private final By tblSeat = By.xpath("//table[contains(@class,'NoBorder')]");
    private final By btnBookTickets = By.xpath("//table[contains(@class,'NoBorder')]//a[contains(@href,'Book')]");

    public TicketPricePage(WebDriver driver) {
        super(driver);
    }

    private WebElement getTblTicketPriceList() {
        return driver.findElement(tblTicketPriceList);
    }

    private List<WebElement> getBtnCheckPrices() {
        return driver.findElements(btnCheckPrices);
    }

    private WebElement getTblTicketPrice() {
        return driver.findElement(tblTicketPrice);
    }

    private WebElement getThTrain() {
        return driver.findElement(thTrain);
    }

    private WebElement getTblSeat() {
        return driver.findElement(tblSeat);
    }

    private List<WebElement> getBtnBookTickets() {
        return driver.findElements(btnBookTickets);
    }

    private void checkPrice(Station departStation, Station arriveStation) {
        getTblTicketPriceList().findElement(By.xpath("//li[contains(., '" + departStation.getName() + "') and contains(., '" + arriveStation.getName() + "')]/ancestor::tr//a[contains(@href,'Price')]")).click();
    }

    private WebElement getTrainFromList(WebElement checkPriceBtn) {
        return checkPriceBtn.findElement(By.xpath("/ancestor::tr//li[contains(@class,'ListSmall')]"));
    }

    private WebElement getSeatFromList(WebElement bookTicketBtn) {
        return bookTicketBtn.findElement(By.xpath("/ancestor::tr//li[contains(@class,'ListSmall')]"));
    }
}
