package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import com.example.railways.dataObjects.SeatType;
import com.example.railways.dataObjects.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage {
    private final By ddlDepartDate = By.xpath("//form//select[@name='Date']");
    private final By ddlDepartStation = By.name("DepartStation");
    private final By ddlArriveStation = By.name("ArriveStation");
    private final By ddlSeatType = By.name("SeatType");
    private final By ddlTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//form//input[@type='submit' and @value='Book ticket']");

    private Select getDdlDepartDate() {
        return new Select(DriverManager.findElement(ddlDepartDate));
    }

    private Select getDdlDepartStation() {
        return new Select(DriverManager.findElement(ddlDepartStation));
    }

    private Select getDdlArriveStation() {
        return new Select(DriverManager.findElement(ddlArriveStation));
    }

    private Select getDdlSeatType() {
        return new Select(DriverManager.findElement(ddlSeatType));
    }

    private Select getDdlTicketAmount() {
        return new Select(DriverManager.findElement(ddlTicketAmount));
    }

    private WebElement getBtnBookTicket() {
        return DriverManager.findElement(btnBookTicket);
    }

    public void bookTicket(String departDate, Station departStation, Station arriveStation, SeatType seatType, int ticketAmount) {
        DriverManager.scrollToView(getBtnBookTicket());
        getDdlDepartDate().selectByVisibleText(departDate);
        getDdlDepartStation().selectByVisibleText(departStation.getName());
        getDdlArriveStation().selectByVisibleText(arriveStation.getName());
        getDdlSeatType().selectByVisibleText(seatType.getName());
        getDdlTicketAmount().selectByVisibleText(String.valueOf(ticketAmount));
        getBtnBookTicket().click();
    }

    public void clickBtnBookTicket() {
        DriverManager.scrollToView(getBtnBookTicket());
        getBtnBookTicket().click();
    }

    public String getSelectedDpStation() {
        DriverManager.scrollToView(getDdlDepartStation().getWrappedElement());
        return getDdlDepartStation().getFirstSelectedOption().getText();
    }

    public String getSelectedArStation() {
        DriverManager.scrollToView(getDdlArriveStation().getWrappedElement());
        return getDdlArriveStation().getFirstSelectedOption().getText();
    }
}
