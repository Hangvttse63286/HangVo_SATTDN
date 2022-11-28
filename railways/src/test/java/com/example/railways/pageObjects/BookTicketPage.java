package com.example.railways.pageObjects;

import com.example.railways.common.utilities.DriverManager;
import com.example.railways.common.utilities.Log;
import com.example.railways.common.utilities.Utilities;
import com.example.railways.dataObjects.SeatType;
import com.example.railways.dataObjects.Station;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

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

    public Station bookTicket() throws InterruptedException {
        DriverManager.scrollToView(getBtnBookTicket());
        getDdlDepartStation().selectByVisibleText(Station.values()[Utilities.getRandomNumber(0,6)].getName());
        List<Station> arStations = getArStationOptions();
        Station arStation = arStations.get(Utilities.getRandomNumber(0,arStations.size()));
        getDdlArriveStation().selectByVisibleText(arStation.getName());
        getBtnBookTicket().click();
        return arStation;
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

    public String getSelectedSeatType() {
        DriverManager.scrollToView(getDdlSeatType().getWrappedElement());
        return getDdlSeatType().getFirstSelectedOption().getText();
    }

    public int getDllDpStationOptionsSize() {
        return getDdlDepartStation().getOptions().size();
    }

    public List<Station> getArStationOptions() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> optionList = getDdlArriveStation().getOptions();
        List<String> arStationList = optionList.stream().map(WebElement::getText).collect(Collectors.toList());
        return arStationList.stream().map(Station::fromString).collect(Collectors.toList());
    }
}
