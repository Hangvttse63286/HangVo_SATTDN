package com.example.railways.pageObjects;

import com.example.railways.dataObjects.SeatType;
import com.example.railways.dataObjects.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage {

    private final By ddlDepartDate = By.xpath("//form//select[@name='Date']");
    private final By ddlDepartStation = By.name("DepartStation");
    private final By ddlArriveStation = By.name("ArriveStation");
    private final By ddlSeatType = By.name("SeatType");
    private final By ddlTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//form//input[@type='submit' and @value='Book ticket']");

    public BookTicketPage(WebDriver driver) {
        super(driver);
    }

    public Select getDdlDepartDate() {
        return new Select(driver.findElement(ddlDepartDate));
    }

    public Select getDdlDepartStation() {
        return new Select(driver.findElement(ddlDepartStation));
    }

    public Select getDdlArriveStation() {
        return new Select(driver.findElement(ddlArriveStation));
    }

    public Select getDdlSeatType() {
        return new Select(driver.findElement(ddlSeatType));
    }

    public Select getDdlTicketAmount() {
        return new Select(driver.findElement(ddlTicketAmount));
    }

    public WebElement getBtnBookTicket() {
        return driver.findElement(btnBookTicket);
    }

    public void bookTicket(String departDate, Station departStation, Station arriveStation, SeatType seatType, int ticketAmount) {
        getDdlDepartDate().selectByVisibleText(departDate);
        getDdlDepartStation().selectByVisibleText(departStation.getName());
        getDdlArriveStation().selectByVisibleText(arriveStation.getName());
        getDdlSeatType().selectByVisibleText(seatType.getName());
        getDdlTicketAmount().selectByVisibleText(String.valueOf(ticketAmount));
        getBtnBookTicket().click();
    }
}
