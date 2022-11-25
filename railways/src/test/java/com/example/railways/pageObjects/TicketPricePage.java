package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import com.example.railways.dataObjects.SeatType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends BasePage {
    private final By tblTicketPrice = By.xpath("//table[contains(@class,'MedTable')]");
    private final By lblTrain = By.xpath("//tr[@class='TableSmallHeader']/th");
    private final By tblSeat = By.xpath("//table[contains(@class,'NoBorder')]");
    private final String seatTypePriceXpath = "//th[contains(text(),'Price')]/..//td[count(//td[.='%s']/preceding-sibling::td)+1]";
    private final String btnBookTicketXPath = "//td[.='%s']/..//a[contains(@href,'Book')]";

    private WebElement getTblTicketPrice() {
        return DriverManager.findElement(tblTicketPrice);
    }

    private WebElement getLblTrain() {
        return getTblTicketPrice().findElement(lblTrain);
    }

    private WebElement getTblSeat() {
        return DriverManager.findElement(tblSeat);
    }

    private WebElement getSeatTypePrice(SeatType seatType) {
        return getTblTicketPrice().findElement(By.xpath(String.format(seatTypePriceXpath, seatType.name())));
    }

    private WebElement getBtnBookTicket(SeatType seatType) {
        return getTblSeat().findElement(By.xpath(String.format(btnBookTicketXPath, seatType.getName())));
    }

    public Long getPrice(SeatType seatType) {
        return Long.parseLong(getSeatTypePrice(seatType).getText());
    }

    public Boolean clickBookTicket(SeatType seatType) {
        try {
            DriverManager.scrollToView(getBtnBookTicket(seatType));
            getBtnBookTicket(seatType).click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
